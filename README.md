# 门卫管理系统  
**基于Spring Boot + DataJPA + Hibernate的校园访客管理系统**

---

## 📌 项目概述  
本系统旨在提升校园访客管理效率，实现**在线申请、审批流程自动化、权限分级管理**等功能。通过数字化手段优化访客登记、权限控制及数据统计，适用于学校、企业等场景的门卫管理需求。

---

## 🛠️ 技术栈  
- **后端框架**：Spring Boot + Spring Security + MyBatis  
- **数据持久层**：Hibernate + JPA  
- **前端页面**：Thymeleaf + Layui + HTML/CSS/JS  
- **数据库**：MySQL 5.7+  
- **开发工具**：IntelliJ IDEA / Eclipse + Maven  

---

## ✨ 功能特性  
1. **访客管理**  
   - 在线提交访客信息（姓名、身份证号、来访事由等）  
   - 上传证件照片自动核验真实性  

2. **审批流程**  
   - 部门负责人在线审核访客申请  
   - 多级审批支持（如院系→保卫处）  

3. **权限控制**  
   - 基于角色的访问控制（RBAC）  
   - 管理员可配置用户权限（如普通用户、审批员、超级管理员）  

4. **数据统计**  
   - 访客记录可视化报表  
   - 高频访客智能预警  

5. **扩展能力**  
   - 待集成：微信扫码快速登记  
   - 待对接：校园门禁系统联动  

---

## 📝 数据库设计  
核心数据表：  
| 表名          | 描述               |  
|---------------|--------------------|  
| `sys_user`    | 用户信息（账号、密码、角色） |  
| `sys_role`    | 权限角色定义       |  
| `visitor_record` | 访客申请记录       |  
| `department`  | 部门信息           |  

**表间关系**：  
- 用户与角色：多对多（`sys_user_role` 关联表）  
- 访客记录与部门：外键关联审批部门  

---

## 🚀 快速入门  
### 1. 环境准备  
- **JDK**：1.8+  
- **Maven**：3.6+  
- **MySQL**：创建数据库并导入 `sql/schema.sql`  

### 2. 项目构建
bash

克隆项目
git clone https://github.com/Cindifind/Meweiguanli.git

导入IDE（推荐使用IDEA）
Maven自动下载依赖
初始化数据库
mysql -u root -p < sql/schema.sql

启动服务
mvn spring-boot:run

### 3. 访问地址  
- **前端页面**：`http://localhost:8080/`  
- **默认账号**：  
  - 管理员：admin/admin123  
  - 普通用户：user/123456  

---

## ⚙️ 高级功能  
1. **API对接**  
   - 提供RESTful接口（`/api/visitor`）供第三方系统调用  
   - 示例请求：
bash

curl -X POST http://localhost:8080/api/visitor\

-H "Content-Type: application/json" \

-d '{"name":"张三","idCard":"11010119900101XXXX","reason":"学术交流"}'

2. **日志审计**  
- 记录所有操作日志（`/logs/system.log`）  
- 支持按时间/用户维度检索  

3. **动态权限刷新**  
- 修改权限配置后无需重启服务  
- 通过 `/actuator/refresh` 端点触发  

---

## 📚 贡献指南  
1. Fork 仓库并创建新分支  
2. 提交代码前请先运行 `mvn test`  
3. 提交PR时请附上功能说明和测试用例  

---

## 📌 注意事项  
1. **安全性**  
- 生产环境需配置HTTPS  
- 敏感操作（如删除记录）需二次确认  

2. **性能优化**  
- 添加Redis缓存高频查询  
- 分页查询默认每页20条  

3. **部署建议**  
- 使用Nginx反向代理静态资源  
- 数据库连接池配置：
properties

spring.datasource.hikari.maximum-pool-size=50

---

## 📜 许可证  
本项目采用 **Mulan PSL v2** 开源协议，允许商业使用但需保留版权声明。  
[许可证全文](https://github.com/Cindifind/Meweiguanli/blob/main/LICENSE)  

---

