# 1.4

> Chapter 1 - Part 1

## Notes

Bài viết này hướng dẫn bạn cách đọc dữ liệu từ file cấu hình (file .properties) để nạp vào ứng dụng Spring Boot bằng việc sử dụng annotation @PropertySource.

Bạn đã code chạy thành công nghĩa là ứng dụng đã đọc được các thông tin (như URL, username, password của database) từ file config.properties và in ra màn hình.

Dưới đây là các khái niệm cốt lõi bài viết muốn truyền tải:

1. Ý nghĩa cốt lõi: Tại sao phải dùng @PropertySource?
Trong thực tế, bạn không nên viết cứng (hardcode) các thông số cấu hình (như tài khoản DB, URL API, secret key) trực tiếp trong file Java. Bạn nên tách chúng ra file riêng (.properties).

Annotation @PropertySource("classpath:config.properties") bảo với Spring rằng:

"Hãy tìm và load file config.properties trong thư mục src/main/resources vào bộ nhớ ứng dụng cho tôi."
2. Hai cách lấy giá trị ra để sử dụng trong code
Bài viết minh họa 2 cách phổ biến để rút giá trị từ file cấu hình ra Java:

Cách 1: Dùng Environment (Inject đối tượng môi trường)
Spring sẽ tự động đọc các giá trị trong file .properties và lưu vào đối tượng Environment. Bạn chỉ cần gọi env.getProperty("tên_key"):

Java
@Autowired
Environment env;

// Lấy giá trị theo key
String driver = env.getProperty("jdbc.driver");
Cách 2: Dùng @Value (Inject trực tiếp vào biến)
Bạn gán trực tiếp giá trị từ file cấu hình vào biến Java bằng cú pháp ${key}:

Java
@Value("${jdbc.driver}")
private String driver;
3. Các tính năng nâng cao bài viết nhắc tới
Dùng biến động (Placeholder):

Cho phép đường dẫn file cấu hình linh hoạt dựa trên một biến môi trường khác.

Ví dụ: @PropertySource("classpath:/com/${my.placeholder:default}/config.properties")

(Nếu biến my.placeholder không tồn tại, nó sẽ dùng chữ default).

Đọc nhiều file cùng lúc (Dùng @PropertySources):

Nếu bạn chia cấu hình ra nhiều file như db.properties, app.properties, bạn có thể bọc chúng lại:

Java
@PropertySources({
    @PropertySource("classpath:config.properties"),
    @PropertySource("classpath:db.properties")
})
Tránh lỗi dừng ứng dụng nếu thiếu file (ignoreResourceNotFound):

Mặc định nếu Spring không tìm thấy file .properties, ứng dụng sẽ bị ngắt và báo lỗi FileNotFoundException. Bật thuộc tính này giúp bỏ qua nếu file đó không tồn tại:

Java
@PropertySource(value = "classpath:missing.properties", ignoreResourceNotFound = true)