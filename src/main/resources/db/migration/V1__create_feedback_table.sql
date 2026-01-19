create table feedback (
    id bigserial primary key,
    email varchar(255) not null,
    content varchar(2000) not null,
    created_at timestamptz not null
);
