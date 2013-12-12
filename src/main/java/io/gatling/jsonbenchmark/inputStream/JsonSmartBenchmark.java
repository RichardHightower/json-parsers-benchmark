
package io.gatling.jsonbenchmark.inputStream;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;

import net.minidev.json.parser.JSONParser;

import org.boon.IO;
import org.openjdk.jmh.logic.BlackHole;

public class JsonSmartBenchmark {

    public static final String STR_ACTION_LABEL_BYTES = ( "data/actionLabel.json" );
    public static final String STR_CITM_CATALOG_BYTES = ( "data/citm_catalog.json" );
    public static final String STR_MEDIUM_BYTES = ( "data/medium.json" );
    public static final String STR_MENU_BYTES = ( "data/menu.json" );
    public static final String STR_SGML_BYTES = ( "data/sgml.json" );
    public static final String  STR_SMALL_BYTES = ( "data/small.json" );
    public static final String STR_WEBXML_BYTES = ( "data/webxml.json" );
    public static final String STR_WIDGET_BYTES = ( "data/widget.json" );


    private Object parse(String str) throws Exception {


        try (InputStream inputStream = Files.newInputStream ( IO.path ( str ) )){
            return new JSONParser().parse( new InputStreamReader ( inputStream));

        }

    }


    public void actionLabel(BlackHole bh) throws Exception {
        bh.consume(parse(STR_ACTION_LABEL_BYTES));
    }

    public void citmCatalog(BlackHole bh) throws Exception {
        bh.consume(parse(STR_CITM_CATALOG_BYTES));
    }

    public void medium(BlackHole bh) throws Exception {
        bh.consume(parse(STR_MEDIUM_BYTES));
    }

    public void menu(BlackHole bh) throws Exception {
        bh.consume(parse(STR_MENU_BYTES));
    }

    public void sgml(BlackHole bh) throws Exception {
        bh.consume(parse(STR_SGML_BYTES));
    }

    public void small(BlackHole bh) throws Exception {
        bh.consume(parse(STR_SMALL_BYTES));
    }

    public void webxml(BlackHole bh) throws Exception {
        bh.consume(parse(STR_WEBXML_BYTES));
    }

    public void widget(BlackHole bh) throws Exception {
        bh.consume(parse(STR_WIDGET_BYTES));
    }

}
