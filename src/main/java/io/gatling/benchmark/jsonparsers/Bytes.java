package io.gatling.benchmark.jsonparsers;

import org.boon.IO;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Bytes {

    public static final byte[] ACTION_LABEL_BYTES = readBytes( "data/actionLabel.json" );
    public static final byte[] CITM_CATALOG_BYTES = readBytes( "data/citm_catalog.json" );
    public static final byte[] MEDIUM_BYTES = readBytes( "data/medium.json" );
    public static final byte[] MENU_BYTES = readBytes( "data/menu.json" );
    public static final byte[] SGML_BYTES = readBytes( "data/sgml.json" );
    public static final byte[] SMALL_BYTES = readBytes( "data/small.json" );
    public static final byte[] WEBXML_BYTES = readBytes( "data/webxml.json" );
    public static final byte[] WIDGET_BYTES = readBytes( "data/widget.json" );

    public static final String STR_ACTION_LABEL_BYTES = readStr( "data/actionLabel.json" );
    public static final String STR_CITM_CATALOG_BYTES = readStr( "data/citm_catalog.json" );
    public static final String STR_MEDIUM_BYTES = readStr( "data/medium.json" );
    public static final String STR_MENU_BYTES = readStr( "data/menu.json" );
    public static final String STR_SGML_BYTES = readStr( "data/sgml.json" );
    public static final String  STR_SMALL_BYTES = readStr( "data/small.json" );
    public static final String STR_WEBXML_BYTES = readStr( "data/webxml.json" );
    public static final String STR_WIDGET_BYTES = readStr( "data/widget.json" );

    private static byte[] readBytes(String path) {
            return IO.read (path ).getBytes ( StandardCharsets.UTF_8 );

    }


    private static String readStr(String path) {
        return IO.read (path );
    }
}
