USE homeworkdb;
CREATE TABLE `t_teacher` (
  `id` varchar(50) NOT NULL COMMENT '老师编号，每个老师唯一',
  `name` varchar(100) NOT NULL COMMENT '老师姓名',
  `password` varchar(50) NOT NULL COMMENT '登陆密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='老师信息表';

CREATE TABLE `t_course` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `name` varchar(100) NOT NULL COMMENT '课程名称',
  `teacher_id` varchar(50) NOT NULL COMMENT '教授该课程老师的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='课程信息表'

CREATE TABLE `t_teaching_class` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '班级id',
  `name` varchar(100) DEFAULT NULL COMMENT '班级名称',
  `course_id` int(10) DEFAULT NULL COMMENT '包含该班级的课程的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='班级表';

CREATE TABLE `t_homework` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '作业id',
  `title` varchar(100) NOT NULL COMMENT '作业名称',
  `description` text COMMENT '作业详情描述',
  `course_id` int(10) NOT NULL COMMENT '作业所属课程的id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `deadline` timestamp NULL DEFAULT NULL COMMENT '作业提交截止日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='作业信息表';

CREATE TABLE `t_student` (
  `id` varchar(50) NOT NULL COMMENT '学生编号，每个学生唯一',
  `name` varchar(100) NOT NULL COMMENT '学生姓名',
  `password` varchar(50) NOT NULL COMMENT '登陆密码',
  `grade` varchar(50) DEFAULT NULL COMMENT '年级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生信息表';

CREATE TABLE `t_homework_status` (
  `student_id` varchar(50) NOT NULL COMMENT '学生id',
  `homework_id` int(10) NOT NULL COMMENT '作业id',
  `teaching_class_id` int(10) NOT NULL COMMENT '班级id，便于统计班级作业完成情况',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '完成状态：0表未完成，1表完成',
  `submission_time` datetime NOT NULL COMMENT '作业提交时间',
  PRIMARY KEY (`student_id`,`homework_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='作业状态表';

CREATE TABLE `t_student_to_teaching_class` (
  `student_id` varchar(50) NOT NULL COMMENT '学生id',
  `teaching_class_id` int(10) NOT NULL COMMENT '教学班id',
  `student_name` varchar(100) NOT NULL COMMENT '学生姓名',
  PRIMARY KEY (`student_id`,`teaching_class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生到班级的映射表'