CREATE TABLE feedback (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    content VARCHAR(2000) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL
);

CREATE INDEX idx_feedback_created_at
    ON feedback (created_at DESC);
