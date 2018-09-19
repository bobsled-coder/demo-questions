INSERT INTO `demo`.`sites` (`site_id`,`site_uuid`,`created_at`,`updated_at`) VALUES (1,UUID_TO_BIN('ba0011e8-58ce-59ad-a004-a44cc8426580'),current_timestamp(),current_timestamp());
INSERT INTO `demo`.`sites` (`site_id`,`site_uuid`,`created_at`,`updated_at`) VALUES (2,UUID_TO_BIN('ca0011e8-58ce-59ad-a004-a44cc8426580'),current_timestamp(),current_timestamp());

INSERT INTO `demo`.`questions` (`question_id`, `question`, `site_id`, `is_deleted`, `created_at`, `updated_at`, `max_num_predictions`, `min_num_predictions`) VALUES (1, 'Test Q#1', '1', '0', current_timestamp(), current_timestamp(), '1', '1');
INSERT INTO `demo`.`questions` (`question_id`, `question`, `site_id`, `is_deleted`, `created_at`, `updated_at`, `max_num_predictions`, `min_num_predictions`) VALUES (2, 'Test Q#2',  '1', '0', current_timestamp(), current_timestamp(), '1', '1');
INSERT INTO `demo`.`questions` (`question_id`, `question`, `site_id`, `is_deleted`, `created_at`, `updated_at`, `max_num_predictions`, `min_num_predictions`) VALUES (3, 'Test Q#3',  '1', '0', current_timestamp(), current_timestamp(), '1', '10');
INSERT INTO `demo`.`questions` (`question_id`, `question`, `site_id`, `is_deleted`, `created_at`, `updated_at`, `max_num_predictions`, `min_num_predictions`) VALUES (4, 'Test Q#4',  '1', '0', current_timestamp(), current_timestamp(), '1', '2');


INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`, `is_answer`) VALUES ('10', '1', 'Falcons', '1', '0', current_timestamp(), current_timestamp(), '0');
INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`, `is_answer`) VALUES ('11', '1', 'Patriots', '2', '0', current_timestamp(), current_timestamp(), '1');

INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('21', '2', 'Nissan', '1', '0', current_timestamp(), current_timestamp());
INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('22', '2', 'Honda', '2', '0', current_timestamp(), current_timestamp());
INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('23', '2', 'Audi', '3', '0', current_timestamp(), current_timestamp());
INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('24', '2', 'BMW', '4', '0', current_timestamp(), current_timestamp());

INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('30', '3', 'Red', '1', '0', current_timestamp(), current_timestamp());
INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('31', '3', 'Blue', '2', '0', current_timestamp(), current_timestamp());
INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('32', '3', 'Yellow', '3', '0', current_timestamp(), current_timestamp());
INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('33', '3', 'Green', '4', '0', current_timestamp(), current_timestamp());
INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('34', '3', 'Black', '5', '0', current_timestamp(), current_timestamp());
INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('35', '3', 'Purple', '6', '0', current_timestamp(), current_timestamp());

INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `column_name`, `column_order`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('40', '4', 'Age/Gender', '1', '<18', '1', '0', current_timestamp(), current_timestamp());
INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `column_name`, `column_order`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('41', '4', 'Age/Gender', '1', '18 to 35', '2', '0', current_timestamp(), current_timestamp());
INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `column_name`, `column_order`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('42', '4', 'Age/Gender', '1', '35 to 55', '3', '0', current_timestamp(), current_timestamp());
INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `column_name`, `column_order`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('43', '4', 'Age/Gender', '1', '> 55', '4', '0', current_timestamp(), current_timestamp());
INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `column_name`, `column_order`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('44', '4', 'Male', '2', '<18', '1', '0', current_timestamp(), current_timestamp());
INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `column_name`, `column_order`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('45', '4', 'Male', '2', '18 to 35', '2', '0', current_timestamp(), current_timestamp());
INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `column_name`, `column_order`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('46', '4', 'Male', '2', '35 to 55', '3', '0', current_timestamp(), current_timestamp());
INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `column_name`, `column_order`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('47', '4', 'Male', '2', '> 55', '4', '0', current_timestamp(), current_timestamp());
INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `column_name`, `column_order`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('48', '4', 'Female', '3', '<18', '1', '0', current_timestamp(), current_timestamp());
INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `column_name`, `column_order`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('49', '4', 'Female', '3', '18 to 35', '2', '0', current_timestamp(), current_timestamp());
INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `column_name`, `column_order`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('50', '4', 'Female', '3', '35 to 55', '3', '0', current_timestamp(), current_timestamp());
INSERT INTO `demo`.`question_predictions` (`question_prediction_id`, `question_id`, `column_name`, `column_order`, `row_name`, `row_order`, `is_deleted`, `created_at`, `updated_at`) VALUES ('51', '4', 'Female', '3', '> 55', '4', '0', current_timestamp(), current_timestamp());


INSERT INTO `demo`.`view_question` (`question_view_uuid`,`user_uuid`,`site_uuid`,`embed_uuid`,`question_id`,`created_at`,`updated_at`) VALUES (UUID_TO_BIN(UUID()),UUID_TO_BIN('ca0011e8-58ce-59ad-a004-a44cc8426581'),UUID_TO_BIN('ba0011e8-58ce-59ad-a004-a44cc8426580'),UUID_TO_BIN(UUID()),'2',current_timestamp(),current_timestamp());
INSERT INTO `demo`.`view_question` (`question_view_uuid`, `user_uuid`, `site_uuid`, `embed_uuid`,`question_id`, `created_at`, `updated_at`) VALUES (UUID_TO_BIN(UUID()), UUID_TO_BIN('ca0011e8-58ce-59ad-a004-a44cc8426582'), UUID_TO_BIN('ba0011e8-58ce-59ad-a004-a44cc8426580'), UUID_TO_BIN(UUID()), '4', current_timestamp(), current_timestamp());