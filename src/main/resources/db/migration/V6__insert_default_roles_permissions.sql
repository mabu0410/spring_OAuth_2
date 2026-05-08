INSERT INTO roles (code, name, description, is_system)
VALUES
    ('ROLE_USER', 'User', 'Default user role', TRUE),
    ('ROLE_ADMIN', 'Admin', 'System administrator role', TRUE)
    ON CONFLICT (code) DO NOTHING;

INSERT INTO permissions (code, name, description, module, action)
VALUES
    ('USER_READ_PROFILE', 'Read user profile', 'Allow user to read profile information', 'USER', 'READ'),
    ('USER_UPDATE_PROFILE', 'Update user profile', 'Allow user to update profile information', 'USER', 'UPDATE'),
    ('ADMIN_READ_USERS', 'Read users', 'Allow admin to read user list', 'ADMIN', 'READ'),
    ('ADMIN_MANAGE_USERS', 'Manage users', 'Allow admin to manage users', 'ADMIN', 'MANAGE')
    ON CONFLICT (code) DO NOTHING;

INSERT INTO role_permissions (role_id, permission_id)
SELECT r.id, p.id
FROM roles r
         JOIN permissions p ON p.code IN (
                                          'USER_READ_PROFILE',
                                          'USER_UPDATE_PROFILE'
    )
WHERE r.code = 'ROLE_USER'
    ON CONFLICT DO NOTHING;

INSERT INTO role_permissions (role_id, permission_id)
SELECT r.id, p.id
FROM roles r
         JOIN permissions p ON p.code IN (
                                          'USER_READ_PROFILE',
                                          'USER_UPDATE_PROFILE',
                                          'ADMIN_READ_USERS',
                                          'ADMIN_MANAGE_USERS'
    )
WHERE r.code = 'ROLE_ADMIN'
    ON CONFLICT DO NOTHING;