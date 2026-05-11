ALTER TABLE users
    ADD COLUMN IF NOT EXISTS external_user_id VARCHAR(100);

ALTER TABLE users
    ADD COLUMN IF NOT EXISTS last_login_at TIMESTAMPTZ;

ALTER TABLE users
    ALTER COLUMN password_hash DROP NOT NULL;

CREATE UNIQUE INDEX IF NOT EXISTS uk_users_external_user_id
    ON users (external_user_id);