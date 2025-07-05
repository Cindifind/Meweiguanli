
package com.example.demo.enums;
public enum HttpStatusEnum {
    OK(200, "OK"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accepted"),
    NO_CONTENT(204, "No Content"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    NOT_IMPLEMENTED(501, "Not Implemented"),
    BAD_GATEWAY(502, "Bad Gateway"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable");

    private final int statusCode;
    private final String description;

    HttpStatusEnum(int statusCode, String description) {
        this.statusCode = statusCode;
        this.description = description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getDescription() {
        return description;
    }

    public static HttpStatusEnum fromStatusCode(int statusCode) {
        for (HttpStatusEnum status : HttpStatusEnum.values()) {
            if (status.getStatusCode() == statusCode) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown status code: " + statusCode);
    }
}
