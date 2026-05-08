package org.example.keyguard.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    // Success: 0xxx
    SUCCESS("0000", "success", HttpStatus.OK),

    //Common / Data errors: 1xxx
    NOT_FOUND("1000", "error.common.not_found", HttpStatus.NOT_FOUND),
    ALREADY_EXISTS("1001", "error.common.already_exists", HttpStatus.BAD_REQUEST),
    INCOMPLETE_DATA("1002", "error.common.incomplete_data", HttpStatus.BAD_REQUEST),
    FORMAT_INCORRECT("1003", "error.common.format_incorrect", HttpStatus.BAD_REQUEST),
    ALREADY_DELETED("1004", "error.common.already_deleted", HttpStatus.BAD_REQUEST),
    INVALID_PARAMETER("1005", "error.common.invalid_parameter", HttpStatus.BAD_REQUEST),
    INVALID_STATUS("1006", "error.common.invalid_status", HttpStatus.BAD_REQUEST),
    INVALID_REQUEST("1007", "error.common.invalid_request", HttpStatus.BAD_REQUEST),
    DUPLICATE_DATA("1008", "error.common.duplicate_data", HttpStatus.BAD_REQUEST),

    // Authentication / Authorization errors: 2xxx
    UNAUTHENTICATED("2000", "error.auth.unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED("2001", "error.auth.unauthorized", HttpStatus.FORBIDDEN),
    ACCESS_DENIED("2002", "error.auth.access_denied", HttpStatus.FORBIDDEN),
    PERMISSION_DENIED("2003", "error.auth.permission_denied", HttpStatus.FORBIDDEN),

    MISSING_TOKEN("2010", "error.auth.missing_token", HttpStatus.UNAUTHORIZED),
    INVALID_TOKEN("2011", "error.auth.invalid_token", HttpStatus.UNAUTHORIZED),
    TOKEN_EXPIRED("2012", "error.auth.token_expired", HttpStatus.UNAUTHORIZED),
    SESSION_EXPIRED("2013", "error.auth.session_expired", HttpStatus.UNAUTHORIZED),
    SESSION_REVOKED("2014", "error.auth.session_revoked", HttpStatus.UNAUTHORIZED),

    PASSWORD_INCORRECT("2020", "error.auth.password_incorrect", HttpStatus.BAD_REQUEST),
    LOGIN_FAILED("2021", "error.auth.login_failed", HttpStatus.BAD_REQUEST),
    TOO_MANY_FAILED_ATTEMPTS("2022", "error.auth.too_many_failed_attempts", HttpStatus.TOO_MANY_REQUESTS),

    // Validation errors: 3xxx
    VALIDATION_FAILED("3000", "error.validation.failed", HttpStatus.BAD_REQUEST),
    FIELD_REQUIRED("3001", "error.validation.field_required", HttpStatus.BAD_REQUEST),
    MIN_LENGTH("3002", "error.validation.min_length", HttpStatus.BAD_REQUEST),
    MAX_LENGTH("3003", "error.validation.max_length", HttpStatus.BAD_REQUEST),
    INVALID_EMAIL("3004", "error.validation.invalid_email", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD_FORMAT("3005", "error.validation.invalid_password_format", HttpStatus.BAD_REQUEST),
    INVALID_DATE_FORMAT("3006", "error.validation.invalid_date_format", HttpStatus.BAD_REQUEST),

    // User business errors: 4xxx
    USER_DISABLED("4000", "error.user.disabled", HttpStatus.FORBIDDEN),
    USER_LOCKED("4001", "error.user.locked", HttpStatus.FORBIDDEN),
    USER_NOT_ACTIVE("4002", "error.user.not_active", HttpStatus.FORBIDDEN),
    EMAIL_ALREADY_EXISTS("4003", "error.user.email_already_exists", HttpStatus.BAD_REQUEST),
    USERNAME_ALREADY_EXISTS("4004", "error.user.username_already_exists", HttpStatus.BAD_REQUEST),

    // Role / Permission business errors: 5xxx
    DELETE_BASIC_ROLE("5000", "error.role.delete_basic_role", HttpStatus.BAD_REQUEST),
    UPDATE_ADMIN_ROLE("5001", "error.role.update_admin_role", HttpStatus.BAD_REQUEST),
    ASSIGN_ROLE_FAILED("5002", "error.role.assign_failed", HttpStatus.BAD_REQUEST),
    REMOVE_ROLE_FAILED("5003", "error.role.remove_failed", HttpStatus.BAD_REQUEST),

    ASSIGN_PERMISSION_FAILED("5100", "error.permission.assign_failed", HttpStatus.BAD_REQUEST),
    REMOVE_PERMISSION_FAILED("5101", "error.permission.remove_failed", HttpStatus.BAD_REQUEST),

    // OAuth errors: 6xxx
    OAUTH_PROVIDER_NOT_SUPPORTED("6000", "error.oauth.provider_not_supported", HttpStatus.BAD_REQUEST),
    OAUTH_ACCOUNT_ALREADY_LINKED("6001", "error.oauth.account_already_linked", HttpStatus.BAD_REQUEST),
    OAUTH_ACCOUNT_NOT_LINKED("6002", "error.oauth.account_not_linked", HttpStatus.BAD_REQUEST),
    OAUTH_LOGIN_FAILED("6003", "error.oauth.login_failed", HttpStatus.BAD_REQUEST),

    // Audit errors: 7xxx
    AUDIT_LOG_FAILED("7000", "error.audit.log_failed", HttpStatus.INTERNAL_SERVER_ERROR),

    // System errors: 9xxx
    UNCATEGORIZED_EXCEPTION("9000", "error.system.uncategorized", HttpStatus.INTERNAL_SERVER_ERROR),
    UNEXPECTED_ERROR("9001", "error.system.unexpected_error", HttpStatus.INTERNAL_SERVER_ERROR),
    SERVICE_UNAVAILABLE("9002", "error.system.service_unavailable", HttpStatus.SERVICE_UNAVAILABLE),
    CONNECTION_ERROR("9003", "error.system.connection_error", HttpStatus.INTERNAL_SERVER_ERROR),
    DATABASE_ERROR("9004", "error.system.database_error", HttpStatus.INTERNAL_SERVER_ERROR),
    INTERNAL_SERVER_ERROR("9005", "error.system.internal_server_error", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;
    private final String messageKey;
    private final HttpStatus httpStatus;

    ErrorCode(String code, String messageKey, HttpStatus httpStatus) {
        this.code = code;
        this.messageKey = messageKey;
        this.httpStatus = httpStatus;
    }
}
