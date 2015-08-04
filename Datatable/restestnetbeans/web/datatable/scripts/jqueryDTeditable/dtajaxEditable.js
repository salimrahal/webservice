/**
 * DT wih editable functionality
 */
var baseUrl = '/restestnetbeans/resttest/currencycalservice/';
$(document).ready(initializeDT);

function initializeDT() {
    console.log("initialize..")
    $("#myDataTable").dataTable({
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": baseUrl + "get",
            "type": "GET",
            "dataSrc": ""
        }// end of ajax,
        ,
        "columns": [{
                "data": "id"
            }, {
                "data": "name"
            }]
    }).makeEditable({
        sAddNewRowFormId: "formAddNewCalender",
        sAddNewRowButtonId: "btnAddNewCalender",
        sAddNewRowOkButtonId: "btnAddNewCalenderOk",
        sAddNewRowCancelButtonId: "btnAddNewCalenderCancel",
        sAddURL: baseUrl + "create",
        sAddHttpMethod: "POST",
        //delete
        sDeleteHttpMethod: "GET",
        sDeleteURL: baseUrl + "del",
        sDeleteRowButtonId: "btnDeleteCalender"
    }
    );
}

function buildJson(data) {
    console.log("data=" + data.id + "/name=" + data.name);
    return data;
}
