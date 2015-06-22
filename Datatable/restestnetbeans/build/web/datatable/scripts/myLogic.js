/**
 * 
 */

function addDT() {
	var tableStr = '<table cellpadding="0" cellspacing="0" border="0" class="display" id="example2">';
	// tableStr += '<thead><tr><th>Id</th><th>Name</th></tr></thead>'
	// tableStr += '<tfoot><tr><th>Id</th><th>Name</th></tr></tfoot>';
	var arrayHeaders=['Id','Name'];
	console.log(arrayHeaders)
	tableStr += buildTableHeader(arrayHeaders);
	$('#demo').html(tableStr);

	$('#example2').dataTable({
		"ajax" : {
			"url" : "/restestnetbeans/resttest/currencycalservice/get",
			"type" : "GET",
			"dataSrc" : ""
		}// end of ajax,
		,
		"columns" : [ {
			"data" : "id"
		}, {
			"data" : "name"
		} ]
	});
}

// build a header element on the same TR
function buildTableHeader(arrayHead) {
	var res = '<thead><tr>';
	// loop thru array and return the thead
	for (var i = 0; i < arrayHead.length; i++) {
		res += '<th>' + arrayHead[i] + '</th>';
	}
	res += '</tr></thead>';
	res += '<tfoot><tr>';
	// loop thru array and return tfoot
	for (var i = 0; i < arrayHead.length; i++) {
		res += '<th>' + arrayHead[i] + '</th>';
	}
	res += '</tfoot></tr>';
	console.log(res)
	return res;
}

$(document).ready(function() {
	console.log("on ready ..");
	$('#example').dataTable({
		"ajax" : {
			"url" : "/RestProject2/resttest/currencycalservice/get",
			"type" : "GET",
			"dataSrc" : ""
		}// end of ajax,
		,
		"columns" : [ {
			"data" : "id"
		}, {
			"data" : "name"
		} ]
	});

});