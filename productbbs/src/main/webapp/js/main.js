function get_product() {
	$("#dg_table").datagrid({
		url: "products",
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

function open_dialog() {
	$("#dlg").dialog({ closed: false, modal: true });
}

function submit_data() {
	$("#user_form").form("submit", {
		url: "insert",
		success: function(data) {
			console.log(data)
			if (data !== '0')
				$('#dg_table').datagrid('reload');

		},
	});

	$("#dlg").dialog("close");
}
