package org.boon;

import com.examples.model.test.movies.admin.AdminService;
import com.examples.model.test.movies.crud.CrudType;
import com.examples.model.test.movies.entitlement.Rights;
import com.examples.model.test.movies.entitlement.RightsCrudRequest;
import com.examples.model.test.movies.entitlement.RightsPushRequest;
import com.examples.model.test.movies.entitlement.RightsType;
import com.examples.model.test.time.TimeZoneType;
import org.boon.core.reflection.BeanUtils;
import org.boon.core.reflection.Invoker;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.boon.Boon.atIndex;
import static org.boon.Boon.puts;
import static org.boon.json.JsonFactory.fromJson;
import static org.boon.json.JsonFactory.toJson;

/**
 * Created by Richard on 4/2/14.
 */
public class InvokerObjectArg {

    static AdminService adminService = new AdminService(){

        @Override
        public boolean rightsPush(RightsPushRequest request) {

            return false;
        }
    };

    static RightsPushRequest rightsPushRequest;
    static String json;

    static {


        Rights rights = Rights.createRights(
                RightsType.AMAZON_PRIME, true, TimeZoneType.EST, System.currentTimeMillis());
        RightsCrudRequest rightsCrudRequest = new RightsCrudRequest("Bob",
                CrudType.ADD, rights);

        RightsCrudRequest rightsCrudRequest2 = BeanUtils.copy(rightsCrudRequest);
        rightsCrudRequest2.setUsername("Rick2");
        RightsCrudRequest rightsCrudRequest3 = BeanUtils.copy(rightsCrudRequest);
        rightsCrudRequest3.setUsername("Jason3");

        List<RightsCrudRequest> rightsList = Lists.list(rightsCrudRequest, rightsCrudRequest2, rightsCrudRequest3);


        rightsPushRequest = new RightsPushRequest(1L, rightsList);

         json = toJson(rightsPushRequest);


    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void rightsInvokeBH(BlackHole bh) throws Exception {
        bh.consume(rightsInvoke());
    }

    private Object rightsInvoke() {

        Object arg = fromJson(json);
        return Invoker.invokeFromObject(adminService, "rightsPush", arg);

    }


    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void serialBH(BlackHole bh) throws Exception {
        bh.consume(serial());
    }

    private Object serial() {

        return fromJson(json);

    }




}
