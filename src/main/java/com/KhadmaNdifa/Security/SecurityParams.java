package com.KhadmaNdifa.Security;

public interface SecurityParams {
    public static final String JWT_HEADER_NAME="Authorization";
    public static final String SECRET="med@youssfi.net";
    public static final long EXPIRATION=360*24*3600;
    public static final String HEADER_PREFIX="Bearer ";
}
