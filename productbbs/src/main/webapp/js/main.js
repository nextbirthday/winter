function clearForm() {
	$("#user_form").form("clear");
}

function get_product() {
	$("#dg_table").datagrid({
		url: "product/selectProduct.kh",
		method: "get",
		emptyMsg: "NO DATA",
		singleSelect: true,
		striped: true,
		rownumbers: true,
		columns: [
			[
				{ field: "id", title: "아이디", width: "10%" },
				{ field: "category", title: "카테고리", width: "25%" },
				{ field: "name", title: "상품명", width: "30%" },
				{ field: "price", title: "가격", width: "20%" },
				{ field: "stock", title: "재고", width: "15%" },
			],
		],
	});
}

function insert_dialog() {
	$("#user_form").form("clear");
	console.log('insert_dialog');
	$("#insertDialog").dialog({ closed: false, modal: true });
}

function update_dialog() {
	console.log('update_dialog');
	const row = $('#dg_table').datagrid('getSelected');
	if (row) {
		alert(row.id + " " + row.category + " " + row.name);
	}

	$("#updateDialog").dialog({ closed: false, modal: true });
}

function submit_data() {
	$("#user_form").form("submit", {
		url: "product/insertProduct.kh",
		success: function(data) {
			console.log(data)
			if (data !== '0')
				$('#dg_table').datagrid('reload');
		},
	});

	$("#insertDialog").dialog("close");
}

