package io.gatling.jsonbenchmark.serializerTests;

import groovy.json.DateFormatThreadLocal;
import groovy.json.JsonDelegate;
import groovy.json.JsonException;
import groovy.json.JsonLexer;
import groovy.json.JsonOutput;
import groovy.json.JsonToken;
import groovy.json.JsonTokenType;
import groovy.json.StringEscapeUtils;
import groovy.lang.Closure;
import groovy.lang.GString;
import groovy.util.Expando;

import java.io.StringReader;
import java.lang.*;import java.lang.Boolean;import java.lang.Character;import java.lang.Double;import java.lang.Enum;import java.lang.Float;import java.lang.IllegalArgumentException;import java.lang.Number;import java.lang.Object;import java.lang.Override;import java.lang.String;import java.lang.StringBuilder;import java.lang.ThreadLocal;import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.UUID;

import org.codehaus.groovy.runtime.DefaultGroovyMethods;

/**
 * Rewritten {@link JsonOutput} to Java.
 * 
 * @author Andrey Bloschetsov
 */
public class MyJsonOutput {

    private static final ThreadLocal<SimpleDateFormat> dateFormatter = new DateFormatThreadLocal();

    /**
     * Simply rewritten to Java with minor changes.
     */
    public static String toJson(Object object) {
        if (object == null) {
            return JsonBlock.NULL.symbol;
        } else if (object instanceof GString) {
            return new StringBuilder().append(JsonBlock.DQUOTE.symbol).append(StringEscapeUtils.escapeJava(((GString) object).toString()))
                    .append(JsonBlock.DQUOTE.symbol).toString();
        } else if (object instanceof String) {
            return new StringBuilder().append(JsonBlock.DQUOTE.symbol).append(StringEscapeUtils.escapeJava((String) object)).append(JsonBlock.DQUOTE.symbol)
                    .toString();
        } else if (object instanceof java.lang.Boolean) {
            return object.toString();
        } else if (object instanceof Number) {
            if ((object.getClass() == Double.class && (((Double) object).isInfinite() || ((Double) object).isNaN()))
                    || (object.getClass() == Float.class && (((Float) object).isInfinite() || ((Float) object).isNaN()))) {

                throw new JsonException("Number " + object + " can't be serialized as JSON: infinite or NaN are not allowed in JSON.");
            }

            return object.toString();
        } else if (object instanceof Date) {
            return new StringBuilder().append(JsonBlock.DQUOTE.symbol).append(dateFormatter.get().format(object)).append(JsonBlock.DQUOTE.symbol).toString();
        } else if (object instanceof Calendar) {
            return new StringBuilder().append(JsonBlock.DQUOTE.symbol).append(dateFormatter.get().format(((Calendar) object).getTime()))
                    .append(JsonBlock.DQUOTE.symbol).toString();
        } else if (object instanceof Collection) {
            Collection<?> collection = (Collection<?>) object;
            StringBuilder sb = new StringBuilder(JsonBlock.START_LIST.symbol);
            Iterator<?> iterator = collection.iterator();
            if (iterator.hasNext()) {
                Object it = iterator.next();
                sb.append(toJson(it));
                while (iterator.hasNext()) {
                    it = iterator.next();
                    sb.append(JsonBlock.COMMA.symbol);
                    sb.append(toJson(it));
                }
            }
            sb.append(JsonBlock.END_LIST.symbol);

            return sb.toString();
        } else if (object instanceof Iterator) {
            Iterator<?> iterator = (Iterator<?>) object;
            StringBuilder sb = new StringBuilder(JsonBlock.START_LIST.symbol);
            if (iterator.hasNext()) {
                Object it = iterator.next();
                sb.append(toJson(it));
                while (iterator.hasNext()) {
                    it = iterator.next();
                    sb.append(JsonBlock.COMMA.symbol);
                    sb.append(toJson(it));
                }
            }
            sb.append(JsonBlock.END_LIST.symbol);

            return sb.toString();
        } else if (object instanceof Map) {
            StringBuilder sb = new StringBuilder(JsonBlock.START_OBJECT.symbol);
            Map<?, ?> m = (Map<?, ?>) object;
            if (!m.isEmpty()) {
                boolean firstItem = true;
                for (Entry<?, ?> entry : m.entrySet()) {
                    if (entry.getKey() == null) {
                        throw new IllegalArgumentException("Maps with null keys can\'t be converted to JSON");
                    }

                    if (!firstItem) {
                        sb.append(JsonBlock.COMMA.symbol);
                    } else {
                        firstItem = false;
                    }
                    sb.append(JsonBlock.DQUOTE.symbol).append(entry.getKey().toString()).append(JsonBlock.DQUOTE.symbol).append(JsonBlock.COLON.symbol)
                            .append(toJson(entry.getValue()));
                }
            } else {
                sb.append(JsonBlock.COLON.symbol);
            }

            return sb.append(JsonBlock.END_OBJECT.symbol).toString();
        } else if (object instanceof URL || object instanceof UUID || object instanceof Character) {
            return new StringBuilder().append(JsonBlock.DQUOTE.symbol).append(object.toString()).append(JsonBlock.DQUOTE.symbol).toString();
        } else if (object instanceof Closure) {
            return toJson(JsonDelegate.cloneDelegateAndGetContent((Closure<?>) object));
        } else if (object instanceof Expando) {
            return toJson(((Expando) object).getProperties());
        } else if (object instanceof Enumeration) {
            Enumeration<?> enumeration = (Enumeration<?>) object;
            StringBuilder sb = new StringBuilder().append(JsonBlock.START_LIST.symbol);
            if (enumeration.hasMoreElements()) {
                Object it = enumeration.nextElement();
                sb.append(toJson(it));
                while (enumeration.hasMoreElements()) {
                    it = enumeration.nextElement();
                    sb.append(JsonBlock.COMMA.symbol);
                    sb.append(toJson(it));
                }
            }
            sb.append(JsonBlock.END_LIST.symbol);

            return sb.toString();
        } else if (object.getClass().isArray()) {
            StringBuilder sb = new StringBuilder().append(JsonBlock.START_LIST.symbol);
            boolean firstItem = true;
            if (object instanceof Object[]) {
                Object[] arr = (Object[]) object;
                for (Object it : arr) {
                    if (!firstItem) {
                        sb.append(JsonBlock.COMMA.symbol);
                    } else {
                        firstItem = false;
                    }
                    sb.append(toJson(it));
                }
            } else if (object instanceof byte[]) {
                byte[] arr = (byte[]) object;
                for (byte it : arr) {
                    if (!firstItem) {
                        sb.append(JsonBlock.COMMA.symbol);
                    } else {
                        firstItem = false;
                    }
                    sb.append(it);
                }
            } else if (object instanceof char[]) {
                char[] arr = (char[]) object;
                for (char it : arr) {
                    if (!firstItem) {
                        sb.append(JsonBlock.COMMA.symbol);
                    } else {
                        firstItem = false;
                    }
                    sb.append(JsonBlock.DQUOTE.symbol).append(it).append(JsonBlock.DQUOTE.symbol);
                }
            } else if (object instanceof boolean[]) {
                boolean[] arr = (boolean[]) object;
                for (boolean it : arr) {
                    if (!firstItem) {
                        sb.append(JsonBlock.COMMA.symbol);
                    } else {
                        firstItem = false;
                    }
                    sb.append(Boolean.toString(it));
                }
            } else if (object instanceof int[]) {
                int[] arr = (int[]) object;
                for (int it : arr) {
                    if (!firstItem) {
                        sb.append(JsonBlock.COMMA.symbol);
                    } else {
                        firstItem = false;
                    }
                    sb.append(it);
                }
            } else if (object instanceof long[]) {
                long[] arr = (long[]) object;
                for (long it : arr) {
                    if (!firstItem) {
                        sb.append(JsonBlock.COMMA.symbol);
                    } else {
                        firstItem = false;
                    }
                    sb.append(it);
                }
            } else if (object instanceof double[]) {
                double[] arr = (double[]) object;
                for (double it : arr) {
                    if (!firstItem) {
                        sb.append(JsonBlock.COMMA.symbol);
                    } else {
                        firstItem = false;
                    }
                    sb.append(it);
                }
            } else if (object instanceof float[]) {
                float[] arr = (float[]) object;
                for (float it : arr) {
                    if (!firstItem) {
                        sb.append(JsonBlock.COMMA.symbol);
                    } else {
                        firstItem = false;
                    }
                    sb.append(it);
                }
            }
            sb.append(JsonBlock.END_LIST.symbol);

            return sb.toString();
        } else if (object instanceof Enum) {
            return new StringBuilder().append(JsonBlock.DQUOTE.symbol).append(((Enum<?>) object).name()).append(JsonBlock.DQUOTE.symbol).toString();
        } else {
            Map<?, ?> properties = DefaultGroovyMethods.getProperties(object);
            properties.remove("class");
            properties.remove("declaringClass");
            properties.remove("metaClass");

            return toJson(properties);
        }
    }

    private static enum JsonBlock {
        START_LIST("["), END_LIST("]"), START_OBJECT("{"), END_OBJECT("}"), COMMA(","), COLON(":"), DQUOTE("\""), NULL("null");

        String symbol;

        JsonBlock(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }
    }

    /**
     * Rewritten to Java without recursions.
     */
    public static String toJsonWithoutRecursion(Object obj) {
        StringBuilder sb = new StringBuilder();
        Queue<Object> stacks = Collections.asLifoQueue(new LinkedList<>());
        stacks.add(obj);
        Queue<Object> temp = Collections.asLifoQueue(new LinkedList<>());

        Object item;
        while (!stacks.isEmpty()) {
            item = stacks.poll();
            if (item == null) {
                sb.append(JsonBlock.NULL.symbol);
            } else if (item instanceof JsonBlock) {
                sb.append(((JsonBlock) item).symbol);
            } else if (item instanceof GString) {
                sb.append(JsonBlock.DQUOTE.symbol).append(StringEscapeUtils.escapeJava(((GString) item).toString())).append(JsonBlock.DQUOTE.symbol);
            } else if (item instanceof String) {
                sb.append(JsonBlock.DQUOTE.symbol).append(StringEscapeUtils.escapeJava((String) item)).append(JsonBlock.DQUOTE.symbol);
            } else if (item instanceof Number) {
                if ((item.getClass() == Double.class && (((Double) item).isInfinite() || ((Double) item).isNaN()))
                        || (item.getClass() == Float.class && (((Float) item).isInfinite() || ((Float) item).isNaN()))) {

                    throw new JsonException("Number " + item + " can't be serialized as JSON: infinite or NaN are not allowed in JSON.");
                }

                sb.append(item.toString());
            } else if (item instanceof Boolean) {
                sb.append(item.toString());
            } else if (item instanceof Date) {
                sb.append(JsonBlock.DQUOTE.symbol).append(dateFormatter.get().format((Date) item)).append(JsonBlock.DQUOTE.symbol).toString();
            } else if (item instanceof Calendar) {
                sb.append(JsonBlock.DQUOTE.symbol).append(dateFormatter.get().format(((Calendar) item).getTime())).append(JsonBlock.DQUOTE.symbol).toString();
            } else if (item instanceof Collection || item instanceof Iterator || item instanceof Enumeration) {
                sb.append(JsonBlock.START_LIST.symbol);
                stacks.add(JsonBlock.END_LIST);

                Iterator<?> iterator;
                if (item instanceof Collection) {
                    iterator = ((Collection<?>) item).iterator();
                } else if (item instanceof Iterator) {
                    iterator = (Iterator<?>) item;
                } else {
                    iterator = Collections.list((Enumeration<?>) item).iterator();
                }
                while (iterator.hasNext()) {
                    temp.add(iterator.next());
                }
                boolean first = true;
                while (!temp.isEmpty()) {
                    if (!first) {
                        stacks.add(JsonBlock.COMMA);
                    } else {
                        first = false;
                    }
                    stacks.add(temp.poll());
                }
            } else if (item instanceof Map || item instanceof Expando) {
                sb.append(JsonBlock.START_OBJECT.symbol);
                stacks.add(JsonBlock.END_OBJECT);

                Map<?, ?> map;
                if (item instanceof Map) {
                    map = (Map<?, ?>) item;
                } else {
                    map = ((Expando) item).getProperties();
                }
                if (!map.isEmpty()) {
                    for (Entry<?, ?> entry : map.entrySet()) {
                        if (entry.getKey() == null) {
                            throw new IllegalArgumentException("Maps with null keys can\'t be converted to JSON");
                        }

                        temp.add(entry.getKey().toString());
                        temp.add(entry.getValue());
                    }
                    boolean firstPair = true;
                    while (!temp.isEmpty()) {
                        if (!firstPair) {
                            stacks.add(JsonBlock.COMMA);
                        } else {
                            firstPair = false;
                        }
                        stacks.add(temp.poll()); // First add value
                        stacks.add(JsonBlock.COLON);
                        stacks.add(temp.poll()); // Then add key
                    }
                } else {
                    sb.append(JsonBlock.COLON.symbol);
                }
            } else if (item instanceof Enum) {
                sb.append(JsonBlock.DQUOTE.symbol).append(((Enum<?>) item).name()).append(JsonBlock.DQUOTE.symbol).toString();
            } else if (item instanceof URL || item instanceof UUID || item instanceof Character) {
                sb.append(JsonBlock.DQUOTE.symbol).append(item.toString()).append(JsonBlock.DQUOTE.symbol).toString();
            } else if (item instanceof Closure) {
                stacks.add(JsonDelegate.cloneDelegateAndGetContent((Closure<?>) item));
            } else if (item.getClass().isArray()) {
                sb.append(JsonBlock.START_LIST.symbol);
                stacks.add(JsonBlock.END_LIST);

                if (item instanceof Object[]) {
                    for (int i = ((Object[]) item).length - 1; i >= 0; i--) {
                        stacks.add(((Object[]) item)[i]);
                        if (i != 0) {
                            stacks.add(JsonBlock.COMMA);
                        }
                    }
                } else if (item instanceof byte[]) {
                    for (int i = ((byte[]) item).length - 1; i >= 0; i--) {
                        sb.append(((byte[]) item)[i]);
                        if (i != 0) {
                            sb.append(JsonBlock.COMMA.symbol);
                        }
                    }
                } else if (item instanceof char[]) {
                    for (int i = ((char[]) item).length - 1; i >= 0; i--) {
                        sb.append(((char[]) item)[i]);
                        if (i != 0) {
                            sb.append(JsonBlock.COMMA.symbol);
                        }
                    }
                } else if (item instanceof int[]) {
                    for (int i = ((int[]) item).length - 1; i >= 0; i--) {
                        sb.append(((int[]) item)[i]);
                        if (i != 0) {
                            sb.append(JsonBlock.COMMA.symbol);
                        }
                    }
                } else if (item instanceof boolean[]) {
                    for (int i = ((boolean[]) item).length - 1; i >= 0; i--) {
                        sb.append(((boolean[]) item)[i]);
                        if (i != 0) {
                            sb.append(JsonBlock.COMMA.symbol);
                        }
                    }
                } else if (item instanceof long[]) {
                    for (int i = ((long[]) item).length - 1; i >= 0; i--) {
                        sb.append(((long[]) item)[i]);
                        if (i != 0) {
                            sb.append(JsonBlock.COMMA.symbol);
                        }
                    }
                } else if (item instanceof double[]) {
                    for (int i = ((double[]) item).length - 1; i >= 0; i--) {
                        sb.append(((double[]) item)[i]);
                        if (i != 0) {
                            sb.append(JsonBlock.COMMA.symbol);
                        }
                    }
                } else if (item instanceof float[]) {
                    for (int i = ((float[]) item).length - 1; i >= 0; i--) {
                        sb.append(((float[]) item)[i]);
                        if (i != 0) {
                            sb.append(JsonBlock.COMMA.symbol);
                        }
                    }
                }
            } else {
                Map<?, ?> properties = DefaultGroovyMethods.getProperties(item);
                properties.remove("class");
                properties.remove("declaringClass");
                properties.remove("metaClass");
                stacks.add(properties);
            }
        }

        return sb.toString();
    }

    public static String prettyPrint(String jsonPayload) {
        int indent = 0;
        StringBuilder output = new StringBuilder();
        JsonLexer lexer = new JsonLexer(new StringReader(jsonPayload));
        while (lexer.hasNext()) {
            JsonToken token = lexer.next();
            if (token.getType() == JsonTokenType.OPEN_CURLY) {
                indent += 4;
                output.append("{\n").append(nSpance(indent));
            } else if (token.getType() == JsonTokenType.CLOSE_CURLY) {
                indent -= 4;
                output.append("\n").append(nSpance(indent)).append("}");
            } else if (token.getType() == JsonTokenType.OPEN_BRACKET) {
                indent += 4;
                output.append("[\n").append(nSpance(indent));
            } else if (token.getType() == JsonTokenType.CLOSE_BRACKET) {
                indent -= 4;
                output.append("\n").append(nSpance(indent)).append("]");
            } else if (token.getType() == JsonTokenType.COMMA) {
                output.append(",\n").append(nSpance(indent));
            } else if (token.getType() == JsonTokenType.COLON) {
                output.append(": ");
            } else if (token.getType() == JsonTokenType.STRING) {
                String textStr = token.getText();
                String textWithoutQuotes = textStr.substring(1, textStr.length() - 1);
                output.append("\"" + StringEscapeUtils.escapeJava(textWithoutQuotes) + "\"");
            } else {
                output.append(token.getText());
            }
        }

        return output.toString();
    }

    private static String nSpance(int n) {
        char[] spaces = new char[n];
        Arrays.fill(spaces, ' ');

        return new String(spaces);
    }

    private MyJsonOutput() {
    }

}
