* 此工程包含两种架构风格的代码演示：三层架构、六边形
* 此示例包含两个用例
  * 添加一本新书，包括书名和价格
  * 显示所有图书，每本书显示书名和价格
* 使用的技术和框架
  * Spring Web, Spring Data JPA, H2（内存数据库）
  * Thymeleaf：提供服务器端的 Web 视图
* 三层架构
  * 包：`iteach.eaap.architecturestyles.layer`
    * 表现层：位于api包，提供以下 API 接口
      * `GET /books`：查看所有图书
      * `POST /books [Content-Type: application/json]`：添加新图书
    * 业务逻辑层：位于`domain`包
    * 持久层：位于 `datasource`包
  * 主类：`LayeredApplication
* 六边形架构
  * 包：`iteach.eaap.architecturestyles.hexagonal`
  * 主类：`HexgonalApplication`
  * 业务逻辑：包名`domain`
  * 入站端口：包名`application.port.in`
    * `BookUseCase`：描述操作用例的接口
  * 出站端口：包名`application.port.out`
    * BookRepository：描述数据库相关的接口
  * 入站适配器：包名 `adapter.in` . 
    * `BookController`：提供基于 `Thymeleaf`模板的视图
    * `RestBookController`：提供基于 REST 的API接口，与三层架构 API 基本相同
  * 出站适配器：包名`adapter.out`
    * `JpaBookRepository`：提供基于 Data JPA 的数据库访问