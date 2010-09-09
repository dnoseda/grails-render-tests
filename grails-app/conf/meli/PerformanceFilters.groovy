package meli



class PerformanceFilters {	
	def filters = {
		all(controller:'*', action:'*') {
			before = {
				def currentTabs = request["vip.performance.tabs"]?: ""
				request["vip.performance.tabs"] = "\t${currentTabs}"
				//log.info("\t${currentTabs}controller: ${controllerName}.${actionName} start")
				request["vip.performance.init"] = System.currentTimeMillis()
			}
			after = {
				request["vip.performance.controller"] = System.currentTimeMillis()
			}
			afterView = {
				long now =System.currentTimeMillis()
				long total = now -request['vip.performance.init']
				long controllerTime = request["vip.performance.controller"] - request['vip.performance.init'] 
				long renderViewTime = now - request["vip.performance.controller"]
				String currentTabs = request["vip.performance.tabs"]?: 0
				request["vip.performance.tabs"] = currentTabs.substring(1)
				if(controllerName == "vip"){
					response.getWriter().write("<div style='display: none;'>render in: ${total}</div>")
				}
				log.info("${currentTabs}controller: ${controllerName}.${actionName} controller: ${controllerTime} view: ${renderViewTime} total: ${total}")
			}
		}
	}
}
