/**
 * 
 */
function creadteDialog() {
	$('#dd').dialog({
		title: '상품입력',
		width: 650,
		height: 250,
		closed: false,
		href: 'insertDialog.jsp',
		modal: true
	});
	$('#dd').dialog('refresh', 'insertDialog.jsp');
}
