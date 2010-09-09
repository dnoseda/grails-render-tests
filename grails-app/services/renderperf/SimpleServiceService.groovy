package renderperf

class SimpleServiceService {

    def serviceMethod() {
		Thread.sleep(100)
		return [0..100]
    }
}
