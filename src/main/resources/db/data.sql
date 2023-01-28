INSERT INTO promotion (name, status, created_at, updated_at) VALUES ('플모1','1',CURRENT_DATE(),CURRENT_DATE());

INSERT INTO coupon (name, promotion_id, type, group_type, issuance_limit, start_at, end_at, created_at, updated_at) VALUES ('쿠폰1', '1', '1', 'c_1', '10', CURRENT_DATE(), CURRENT_DATE(), CURRENT_DATE(), CURRENT_DATE());
INSERT INTO coupon (name, promotion_id, type, group_type, issuance_limit, start_at, end_at, created_at, updated_at) VALUES ('쿠폰2', '1', '2', 'c_2', '5', CURRENT_DATE(), CURRENT_DATE(), CURRENT_DATE(), CURRENT_DATE());
INSERT INTO coupon (name, promotion_id, type, group_type, issuance_limit, start_at, end_at, created_at, updated_at) VALUES ('쿠폰3', '1', '3', 'c_3', '1', CURRENT_DATE(), CURRENT_DATE(), CURRENT_DATE(), CURRENT_DATE());