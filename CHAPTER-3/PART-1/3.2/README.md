# 3.2

> Chapter 3 - Part 1

## Notes
hoc ve các annotation
## Các Annotation Validation Thường Dùng Trong Spring Boot

Dưới đây là bảng tổng hợp các annotation kiểm tra dữ liệu (validation) phổ biến cùng ý nghĩa và ví dụ cụ thể:

| Annotation | Ý nghĩa & Quy tắc kiểm tra | Ví dụ áp dụng |
| :--- | :--- | :--- |
| `@NotNull` | Giá trị **không được là `null`**. Chấp nhận chuỗi rỗng `""` hoặc chuỗi chỉ chứa khoảng trắng `" "`. | `@NotNull(message = "Id không được null")`<br>`private Long id;` |
| `@NotEmpty` | Giá trị **không được `null` và độ dài phải > 0** (không được rỗng `""`). Áp dụng cho Chuỗi, Collection, Map, Mảng. | `@NotEmpty(message = "Danh sách không được rỗng")`<br>`private List<String> tags;` |
| `@NotBlank` | Giá trị **không được `null`, không rỗng và không được chỉ chứa khoảng trắng**. Chỉ áp dụng cho kiểu Chuỗi (`String`). | `@NotBlank(message = "Tên không được để trống")`<br>`private String name;` |
| `@Min(value)` | Giá trị số phải **lớn hơn hoặc bằng** giá trị `value` định sẵn. Áp dụng cho các kiểu số (byte, short, int, long,...). | `@Min(value = 18, message = "Tuổi phải từ 18 trở lên")`<br>`private int age;` |
| `@Max(value)` | Giá trị số phải **nhỏ hơn hoặc bằng** giá trị `value` định sẵn. Áp dụng cho các kiểu số. | `@Max(value = 100, message = "Điểm tối đa là 100")`<br>`private int score;` |
| `@Pattern` | Kiểm tra chuỗi phải **khớp với biểu thức chính quy (Regex)** được khai báo trong `regexp`. | `@Pattern(regexp = "^0[0-9]{9}$", message = "Số điện thoại không hợp lệ")`<br>`private String phone;` |
| `@Email` | Kiểm tra **định dạng chuỗi phải là một email hợp lệ** (chứa ký tự `@`, tên miền,...). | `@Email(message = "Email không đúng định dạng")`<br>`private String email;` |
| `@Size` | Kiểm tra **số lượng phần tử hoặc độ dài chuỗi** nằm trong khoảng từ `min` đến `max`. Áp dụng cho String, Collection, Map, Mảng. | `@Size(min = 6, max = 20, message = "Mật khẩu từ 6-20 ký tự")`<br>`private String password;` |

---

### Phân biệt bộ ba kiểm tra Rỗng

* **`@NotNull`**: Chỉ ngăn chặn `null`.
* **`@NotEmpty`**: Ngăn chặn `null` và `""` (chuỗi rỗng).
* **`@NotBlank`**: Ngăn chặn `null`, `""` và `"   "` (khoảng trắng). **Nên ưu tiên dùng `@NotBlank` cho thuộc tính kiểu String**.

Handling Validation Errors để biến các exception validation thành response có ý nghĩa hơn
ErrorResponse
        +
@RestControllerAdvice
        +
@ExceptionHandler