package io.gatling.benchmark.util;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * Inspired from Netty's PlatformDependant0
 * @author slandelle
 */
public final class UnsafeUtil {
    public static final Unsafe UNSAFE;
    public static final long STRING_VALUE_FIELD_OFFSET;
    public static final long STRING_OFFSET_FIELD_OFFSET;
    public static final long STRING_COUNT_FIELD_OFFSET;

    static {
        Unsafe unsafe;
        try {
            Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            unsafe = (Unsafe) unsafeField.get(null);

        } catch (Throwable cause) {
            unsafe = null;
        }

        long stringValueFieldOffset = -1L;
        long stringOffsetFieldOffset = -1L;
        long stringCountFieldOffset = -1L;

        if (unsafe != null) {
            try {
                stringValueFieldOffset = unsafe.objectFieldOffset(String.class.getDeclaredField("value"));
                stringOffsetFieldOffset = unsafe.objectFieldOffset(String.class.getDeclaredField("offset"));
                stringCountFieldOffset = unsafe.objectFieldOffset(String.class.getDeclaredField("count"));
            } catch (Throwable cause) {
            }
        }

        UNSAFE = unsafe;
        STRING_VALUE_FIELD_OFFSET = stringValueFieldOffset;
        STRING_OFFSET_FIELD_OFFSET = stringOffsetFieldOffset;
        STRING_COUNT_FIELD_OFFSET = stringCountFieldOffset;
    }

    public static boolean hasUnsafe() {
        return UNSAFE != null;
    }

    public static char[] getChars(String string) {
        if (UNSAFE != null) {
            char[] value = (char[]) UNSAFE.getObject(string, STRING_VALUE_FIELD_OFFSET);

            if (STRING_OFFSET_FIELD_OFFSET != -1) {
                // old String version with offset and count
                int offset = (int) UNSAFE.getObject(string, STRING_OFFSET_FIELD_OFFSET);
                int count = (int) UNSAFE.getObject(string, STRING_COUNT_FIELD_OFFSET);

                if (offset == 0 && count == value.length) {
                    // no need to copy
                    return value;

                } else {
                    char result[] = new char[count];
                    System.arraycopy(value, offset, result, 0, count);
                    return result;
                }

            } else {
                return value;
            }

        } else {
            return string.toCharArray();
        }
    }
}
