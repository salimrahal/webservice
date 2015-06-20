
function callWS(){
	//example of returned json {"Fname":"sasa","Lname":"last","gender":"Male","food[]":["Steak","Pizza","Chicken"],"quote":"i love u","education":"HighSchool","TofD":"Night"}"
	var paramsJsonStr =  extractParamAsJsonStr();
	//todo: send json request to web service
}


function extractParamAsJsonStr(){
	//get form vars as Json: convert JS Object to JSON string
	var paramsAsJsonStr = JSON.stringify($('form').serializeObject());
	console.log("JSON.stringify($('form').serializeObject()="+paramsAsJsonStr);
	return paramsAsJsonStr;
}


//retrieve params
$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

$(function() {
    $('form').submit(function() {
        $('#result').text(JSON.stringify($('form').serializeObject()));
        return false;
    });
});

