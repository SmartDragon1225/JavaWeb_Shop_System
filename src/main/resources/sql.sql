create table address
(
    id           bigint auto_increment comment '主键ID'
        primary key,
    contact      varchar(15) null comment '联系人姓名',
    addressDesc  varchar(50) null comment '收货地址明细',
    postCode     varchar(15) null comment '邮编',
    tel          varchar(20) null comment '联系人电话',
    createdBy    bigint      null comment '创建者',
    creationDate datetime    null comment '创建时间',
    modifyBy     bigint      null comment '修改者',
    modifyDate   datetime    null comment '修改时间',
    userId       bigint      null comment '用户ID'
)collate = utf8_unicode_ci;
#插入数据

create table order
(
    id           bigint auto_increment comment '主键ID'
        primary key,
    billCode     varchar(20)    null comment '账单编码',
    productName  varchar(20)    null comment '商品名称',
    productDesc  varchar(50)    null comment '商品描述',
    productUnit  varchar(10)    null comment '商品单位',
    productCount decimal(20, 2) null comment '商品数量',
    totalPrice   decimal(20, 2) null comment '商品总额',
    isPayment    int            null comment '是否支付（1：未支付 2：已支付）',
    createdBy    bigint         null comment '创建者（userId）',
    creationDate datetime       null comment '创建时间',
    modifyBy     bigint         null comment '更新者（userId）',
    modifyDate   datetime       null comment '更新时间',
    providerId   bigint         null comment '供应商ID'
)collate = utf8_unicode_ci;
#插入数据


create table provider
(
    id           bigint auto_increment comment '主键ID'
        primary key,
    proCode      varchar(20) null comment '供应商编码',
    proName      varchar(20) null comment '供应商名称',
    proDesc      varchar(50) null comment '供应商详细描述',
    proContact   varchar(20) null comment '供应商联系人',
    proPhone     varchar(20) null comment '联系电话',
    proAddress   varchar(50) null comment '地址',
    proFax       varchar(20) null comment '传真',
    createdBy    bigint      null comment '创建者（userId）',
    creationDate datetime    null comment '创建时间',
    modifyDate   datetime    null comment '更新时间',
    modifyBy     bigint      null comment '更新者（userId）'
)collate = utf8_unicode_ci;
#插入数据

create table role
(
    id           bigint auto_increment comment '主键ID'
        primary key,
    roleCode     varchar(15) null comment '角色编码',
    roleName     varchar(15) null comment '角色名称',
    createdBy    bigint      null comment '创建者',
    creationDate datetime    null comment '创建时间',
    modifyBy     bigint      null comment '修改者',
    modifyDate   datetime    null comment '修改时间'
)collate = utf8_unicode_ci;
#插入数据

create table user
(
    id           bigint auto_increment comment '主键ID'
        primary key,
    userCode     varchar(15) null comment '用户编码',
    userName     varchar(15) null comment '用户名称',
    userPassword varchar(15) null comment '用户密码',
    gender       int         null comment '性别（1:女、 2:男）',
    birthday     date        null comment '出生日期',
    phone        varchar(15) null comment '手机',
    address      varchar(30) null comment '地址',
    userRole     bigint      null comment '用户角色（取自角色表-角色id）',
    createdBy    bigint      null comment '创建者（userId）',
    creationDate datetime    null comment '创建时间',
    modifyBy     bigint      null comment '更新者（userId）',
    modifyDate   datetime    null comment '更新时间'
)collate = utf8_unicode_ci;
#插入数据
