package renderperf

class BorrameController {
	SimpleServiceService simpleServiceService
    def index = {
		render(view:"/vips/borrameView")
	}
	
	def index2 = {
		return [result:simpleServiceService.serviceMethod()]
	}
	def index3 = {
		render "index3"
	}
	def index4 = {
		render "index4"
	}
	def index5 = {
		render "index5"
	}
}
