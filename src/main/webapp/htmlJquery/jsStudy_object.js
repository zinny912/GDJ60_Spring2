
let car = {
    brand:'AUDI', 
    price:3000,
    info:function(){
        console.log(this.brand,this.price);
    }
}



//class선언 : 클래스 안에 선언된 애들은 메서드 / 일반적으로 쓰는 애들은 함수
class Student{
    #n='';
    #kor;

    //setter 메서드
    set n(n){
        this.#n=n;
    }
    //getter 메서드
    get n(){
        return this.#n;
    }

    set kor(kor){
        this.#kor=kor;
    }

    get kor(){
        return this.#kor;
    }

    info(){
    console.log(this.#n, this.#kor);
}

    //#변수명 : private 의미
} 


const btn1 = document.getElementById('btn1');

btn1.addEventListener('click', function(){
    // console.log(car.brand);
    // car.info();
    // car.color ='RED';
    
    // console.log('For in');
    // for(let v in car){
    //     console.log(car[v]);
    // }
    let s = new Student();
    s.n='iu';
    s.kor=100;
    s.eng=100;
    s.info();
    console.log(s.eng);
    console.log(s.n, s.kor);
    
    let s1 = new Student();

})
