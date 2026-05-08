CREATE TABLE IF NOT EXISTS audit_logs (
                                          id BIGSERIAL PRIMARY KEY,

                                          user_id BIGINT,

                                          action VARCHAR(150) NOT NULL,
    module VARCHAR(100),
    description TEXT,

    ip_address VARCHAR(100),
    user_agent TEXT,

    request_method VARCHAR(20),
    request_uri TEXT,

    status VARCHAR(30) DEFAULT 'SUCCESS',

    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),

    CONSTRAINT fk_audit_logs_user
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL,

    CONSTRAINT chk_audit_logs_status
    CHECK (status IN ('SUCCESS', 'FAILED', 'ERROR'))
    );

CREATE INDEX IF NOT EXISTS idx_audit_logs_user_id ON audit_logs(user_id);
CREATE INDEX IF NOT EXISTS idx_audit_logs_action ON audit_logs(action);
CREATE INDEX IF NOT EXISTS idx_audit_logs_module ON audit_logs(module);
CREATE INDEX IF NOT EXISTS idx_audit_logs_created_at ON audit_logs(created_at);