CREATE TABLE IF NOT EXISTS users (
                                     id BIGSERIAL PRIMARY KEY,

                                     email VARCHAR(255) NOT NULL UNIQUE,
    username VARCHAR(100),
    full_name VARCHAR(255),
    avatar_url TEXT,

    phone VARCHAR(30),

    status VARCHAR(30) NOT NULL DEFAULT 'ACTIVE',
    email_verified BOOLEAN NOT NULL DEFAULT FALSE,

    -- Sau này dùng Keycloak thì lưu sub/user_id của Keycloak ở đây
    external_user_id VARCHAR(255),

    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    last_login_at TIMESTAMPTZ,

    deleted BOOLEAN NOT NULL DEFAULT FALSE,

    CONSTRAINT chk_users_status
    CHECK (status IN ('ACTIVE', 'INACTIVE', 'LOCKED', 'DELETED'))
    );

CREATE INDEX IF NOT EXISTS idx_users_email ON users(email);
CREATE INDEX IF NOT EXISTS idx_users_status ON users(status);
CREATE INDEX IF NOT EXISTS idx_users_external_user_id ON users(external_user_id);
CREATE INDEX IF NOT EXISTS idx_users_deleted ON users(deleted);