ALTER TABLE audit_logs
    ADD COLUMN resource_type VARCHAR(50),
ADD COLUMN resource_id VARCHAR(100);