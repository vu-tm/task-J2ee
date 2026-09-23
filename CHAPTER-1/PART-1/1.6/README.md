# 1.6

> Chapter 1 - Part 1

## Notes
CUSTOM SCOPE

Spring cho phép tự định nghĩa Scope cho Bean.

Thread-local Scope:
- Mỗi Thread có một instance riêng.
- Trong cùng Thread, lấy Bean nhiều lần vẫn nhận cùng instance.
- Các Thread khác nhau nhận instance khác nhau.

Ví dụ:

Thread 1:
getBean() → A
getBean() → A
=> A == A → true

Thread 2:
getBean() → B
getBean() → B
=> B == B → true

Nhưng:
A != B

Cách tạo:
1. Implement org.springframework.beans.factory.config.Scope
2. Dùng ThreadLocal để lưu Bean theo từng Thread
3. Đăng ký custom scope với CustomScopeConfigurer
4. Gắn @Scope("thread-local") cho Bean cần dùng scope đó.

