# 1.5

> Chapter 1 - Part 1

## Notes
bài bày dạy về @Autowired, @Component và @Qualifier trong Spring
@Autowired: hãy tìm 1 object phù hợp trong Spring Container và truyền nó vào đây
2. Spring Container là gì?
Khi chạy:
SpringApplication.run(SpringAnnotationApplication.class, args);
Spring bắt đầu tạo một Spring Container.

Bạn có thể hình dung nó như một cái kho:
Spring Container
│
├── VegPizza object
│
├── PizzaController object
│
└── ...

Những class có: @Component
sẽ được Spring phát hiện và tạo object quản lý.
@Component nói với Spring:
"Class này hãy để Spring quản lý."
Bây giờ tới PizzaController

Bạn có:

@Component
public class PizzaController
Có @Component, nên Spring cũng quản lý class này.
Spring muốn tạo:
PizzaController
Nhưng constructor của nó là:

@Autowired
public PizzaController(@Qualifier("vegPizza") Pizza pizza){
    System.out.println("inside pizza controller constructor");
    this.pizza=pizza;
}

Spring nhìn thấy:

Pizza pizza và @Autowired
Nó hiểu:
"À, khi tạo PizzaController, mình cần truyền vào một Bean có kiểu Pizza."
đây là lúc nhiệm vụ của @Qualifier
vì có veg pizza và non-veg pizza cùng implement pizza nên spring sẽ không biết chọn cái nào
@Qualifier("vegPizza") giải quyết vấn đề đó

Bạn viết:

@Autowired
public PizzaController(@Qualifier("vegPizza") Pizza pizza)

Có thể đọc thành tiếng Việt:

"Spring, hãy inject cho tôi Bean kiểu Pizza, nhưng cụ thể phải là Bean có tên vegPizza."

Vậy Spring tìm:

Pizza
│
├── vegPizza       ← CHỌN
│
└── nonVegPizza

và truyền:

VegPizza

vào constructor.
luồng
var context = SpringApplication.run(SpringAnnotationApplication.class,args);
scan tất cả các class có @Component rồi tạo các object tương ứng rồi đưa cho Spring Container quản lý
phân biệt 3 kiểu injection
1. constructor injection
sau khi quét qua 3 class veg, non veg và controller thì tạo 2 object veg và non veg còn controller có constructor thì phải vào xem xét, thấy
Spring khởi động
      ↓
Component Scan
      ↓
Phát hiện VegPizza
      ↓
Phát hiện NonVegPizza
      ↓
Phát hiện PizzaController
      ↓
Spring cần tạo PizzaController
      ↓
Kiểm tra constructor
      ↓
Constructor cần Pizza
      ↓
Có nhiều Bean cùng kiểu Pizza
      ↓
@Qualifier("vegPizza")
      ↓
Chọn Bean "vegPizza"
      ↓
Lấy VegPizza object
      ↓
Gọi constructor
      ↓
new PizzaController(vegPizza)
      ↓
this.pizza = vegPizza
      ↓
PizzaController hoàn thành
2. Setter Injection
Spring khởi động
      ↓
Scan @Component
      ↓
Phát hiện VegPizza
      ↓
Tạo VegPizza object
      ↓
Phát hiện PizzaController
      ↓
Tạo PizzaController object
      ↓
PizzaController được tạo
      ↓
Spring tìm @Autowired trên setter
      ↓
@Qualifier("vegPizza")
      ↓
Tìm Bean "vegPizza"
      ↓
Lấy VegPizza object
      ↓
Gọi setPizza(vegPizza)
      ↓
this.pizza = vegPizza
      ↓
Injection hoàn thành
3. Field injection
Spring khởi động
      ↓
Scan @Component
      ↓
Phát hiện VegPizza
      ↓
Tạo VegPizza object
      ↓
Phát hiện PizzaController
      ↓
Tạo PizzaController object
      ↓
Spring kiểm tra các field
      ↓
Phát hiện @Autowired
      ↓
@Qualifier("vegPizza")
      ↓
Tìm Bean "vegPizza"
      ↓
Lấy VegPizza object
      ↓
Inject vào field pizza
      ↓
pizza = VegPizza
      ↓
Injection hoàn thành