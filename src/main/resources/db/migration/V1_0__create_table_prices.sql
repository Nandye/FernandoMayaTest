CREATE SCHEMA IF NOT EXISTS "fernando";
CREATE TABLE IF NOT EXISTS "fernando".prices (

    brand_id BIGINT,
    start_date timestamp,
    end_date timestamp,
    price_list INT,
    product_id BIGINT,
    priority INT,
    price FLOAT,
    curr VARCHAR(5)

);