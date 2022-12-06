"# android" 


Logic bài Currency
Activity_main.xml

- Lấy text từ EditText
- Chuyển text sang kiểu Float
    + nếu text là chữ => cho vào try catch
    + nếu text là số => lấy kết quả
- dùng kết quả vừa chuyển cho vào công thức chuyển tiền
- kiểm tra xem đang chuyển từ loại tiền nào sang loại tiền nào
    + CYN => KRw        CYN => EUR      CYN => USD      CYN => JPY      CYN => VND

    + KRW => CYN        KRW => EUR      KRW => USD      KRW => JPY      KRW => VND

    + EUR => CYN        EUR => KRW      EUR => USD      EUR => JPY      EUR => VND

    + USD => CYN        USD => KRW      USD => EUR      USD => JPY      USD => VND

    + JPY => CYN        JPY => KRW      JPY => EUR      JPY => USD      JPY => VND

    + VND => CYN        VND => KRW      VND => EUR      VND => USD      VND => JPY

- Button Convert: khi ấn thực hiện chuyển đổi theo các công thức
- Button Clear: Khi ấn set lại text của fromEdit và toEdit là rỗng
- Button options: Khi ấn thì mở Activity_options lên 

Activity_options.xml
- Nếu 1 radio button được check thì disable cái tương ứng đi
- Ấn vào return thì quay lại Activity_main
- Có 2 cách để tạo ra cách tương tác của người dùng với việc chọn
    + Cách đơn giản: tạo thêm một nút để khi ấn vào sẽ gửi dữ liệu sang Activity_main.xml
    + Cách phức tạp: không tạo thêm mà kiểm tra xem người dùng đã ấn đủ 2 radio button hay chưa
        + Nếu người dùng đã ấn thì gửi dữ liệu sang Activity_main
        + Có một trường hợp là trong Activity_options đã có sẵn những lựa chọn, mình cẩn tạo ra một default hoặc check xem người dùng đã tương tác gì hay chưa

