package reactorexe;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

// <T> 발행할 데이터 타입
public class MySubscriber implements Subscriber<Integer> {

	private Integer size = 1000000000; // nobounded
	private Subscription s;
	
	public void onSubscribe(Subscription s) {
		this.s = s;
		System.out.println("3. MySubscriber - 구독 정보 돌려 받음.");
		// 신문 줘!
		s.request(size); //내가 하루에 읽을 수 있는 글자수의 한계 (백프레셔 = BackPressure)
		
	}

	//데이터를 돌려받는 함수
	public void onNext(Integer t) {
		System.out.println("onNext - 신문"+t);
		size--; //1
		
		if(size == 0) {
			size = 3;
			s.request(size);
		}
		
	}

	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		
	}

	public void onComplete() {
		System.out.println("신문 다 받음");
		
	}

}
