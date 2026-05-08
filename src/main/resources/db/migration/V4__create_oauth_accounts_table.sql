CREATE TABLE IF NOT EXISTS oauth_accounts (
                                              id BIGSERIAL PRIMARY KEY,

                                              user_id BIGINT NOT NULL,

                                              provider VARCHAR(50) NOT NULL,
    provider_user_id VARCHAR(255) NOT NULL,

    provider_email VARCHAR(255),
    provider_username VARCHAR(150),
    provider_avatar_url TEXT,

    access_token TEXT,
    refresh_token TEXT,
    token_type VARCHAR(50),
    scope TEXT,
    expires_at TIMESTAMPTZ,

    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),

    CONSTRAINT fk_oauth_accounts_user
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,

    CONSTRAINT uq_oauth_provider_user
    UNIQUE (provider, provider_user_id)
    );

CREATE INDEX IF NOT EXISTS idx_oauth_accounts_user_id ON oauth_accounts(user_id);
CREATE INDEX IF NOT EXISTS idx_oauth_accounts_provider ON oauth_accounts(provider);
CREATE INDEX IF NOT EXISTS idx_oauth_accounts_provider_email ON oauth_accounts(provider_email);