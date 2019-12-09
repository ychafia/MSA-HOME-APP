ALTER TABLE `note` CHANGE `description_note` `description_note` LONGTEXT CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL;

INSERT INTO `note` (`id_note`, `completed_note`, `description_note`, `recall_date_note`, `title_note`, `updated_timestamp`)
VALUES ('4', b'0', 'sscsc', '2019-11-20 00:00:00', 'csscs', '2019-11-20 00:00:00');

