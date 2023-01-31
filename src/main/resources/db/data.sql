INSERT INTO promotion (name, title, status, start_at, end_at, created_at, updated_at) VALUES ('promo1', '플모1','1',CURRENT_DATE(),CURRENT_DATE(),CURRENT_DATE(),CURRENT_DATE());

INSERT INTO coupon (name, promotion_id, type, group_type, issuance_limit, quest_type, quest_value, start_at, end_at, created_at, updated_at) VALUES ('쿠폰1', '1', '1', 'c_1', '10', 'mission','10', CURRENT_DATE(), CURRENT_DATE(), CURRENT_DATE(), CURRENT_DATE());
INSERT INTO coupon (name, promotion_id, type, group_type, issuance_limit, quest_type, quest_value, start_at, end_at, created_at, updated_at) VALUES ('쿠폰2', '1', '2', 'c_2', '5', 'limit','20', CURRENT_DATE(), CURRENT_DATE(), CURRENT_DATE(), CURRENT_DATE());
INSERT INTO coupon (name, promotion_id, type, group_type, issuance_limit, quest_type, quest_value, start_at, end_at, created_at, updated_at) VALUES ('쿠폰3', '1', '3', 'c_3', '1', 'level','30', CURRENT_DATE(), CURRENT_DATE(), CURRENT_DATE(), CURRENT_DATE());

INSERT INTO ticket (user_id, coupon_id, result_code, result_log, created_at, updated_at) values ('song' , '1', 'SUCCESS', 'log', CURRENT_DATE(), CURRENT_DATE());
INSERT INTO ticket (user_id, coupon_id, result_code, result_log, created_at, updated_at) values ('song' , '2', 'SUCCESS', 'log', CURRENT_DATE(), CURRENT_DATE());
INSERT INTO ticket (user_id, coupon_id, result_code, result_log, created_at, updated_at) values ('song' , '3', 'SUCCESS', 'log', CURRENT_DATE(), CURRENT_DATE());

-- INSERT INTO quest (coupon_id, quest_type, quest_value, created_at, updated_at) VALUES ('1', 'mission','10',CURRENT_DATE(),CURRENT_DATE());
-- INSERT INTO quest (coupon_id, quest_type, quest_value, created_at, updated_at) VALUES ('2', 'limit','20',CURRENT_DATE(),CURRENT_DATE());
-- INSERT INTO quest (coupon_id, quest_type, quest_value, created_at, updated_at) VALUES ('3', 'level','30',CURRENT_DATE(),CURRENT_DATE());