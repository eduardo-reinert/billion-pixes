CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),  -- unique user ID
    email VARCHAR(255) UNIQUE NOT NULL,              -- login identifier
    password_hash VARCHAR(255) NOT NULL,             -- store bcrypt/argon2 hash
    full_name VARCHAR(255),                          -- optional name field
    is_verified BOOLEAN DEFAULT FALSE,               -- email verification
    role VARCHAR(50) DEFAULT 'user',                 -- roles: user, admin, etc.
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- record creation
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP   -- record last update
);
CREATE INDEX idx_users_email ON users(email);
