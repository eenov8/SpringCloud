var config = (function() {
    return {
        
        apiServer: function (){
			var ip = location.protocol+'//'+location.hostname;
			return ip+":8090/IndusRoot/";

        }
    };
})();
