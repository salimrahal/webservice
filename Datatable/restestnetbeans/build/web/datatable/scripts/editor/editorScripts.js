/**
 * 
 */
var editor; // use a global for the submit and return data rendering in the examples

$(document).ready(function() {
	
	 /*
    editor = new $.fn.dataTable.Editor( {
        ajax: {
            create: {
                type: 'POST',
                url:  '../php/rest/create.php'
            },
            edit: {
                type: 'PUT',
                url:  '../php/rest/edit.php?id=_id_'
            },
            remove: {
                type: 'DELETE',
                url:  '../php/rest/remove.php?id=_id_'
            }
        },
        table: "#example",
        fields: [ {
                label: "First name:",
                name: "first_name"
            }, {
                label: "Last name:",
                name: "last_name"
            }, {
                label: "Position:",
                name: "position"
            }, {
                label: "Office:",
                name: "office"
            }, {
                label: "Extension:",
                name: "extn"
            }, {
                label: "Start date:",
                name: "start_date"
            }, {
                label: "Salary:",
                name: "salary"
            }
        ]
    } );
*/ 
    $('#example').DataTable( {
        dom: "Tfrtip",
        //ajax: "../php/rest/get.php",
        ajax: "http://localhost:8081/RestProject2/resttest/currencycalservice/get",
        columns: [
            { CurrencyCalendar: "id" },
            { CurrencyCalendar: "name" },
        ],
        tableTools: {
            sRowSelect: "os",
            aButtons: [
                { sExtends: "editor_create", editor: editor },
                { sExtends: "editor_edit",   editor: editor },
                { sExtends: "editor_remove", editor: editor }
            ]
        }
    } );
} );