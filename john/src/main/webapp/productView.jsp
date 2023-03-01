<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품정보</title>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.10.14/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.10.14/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.10.14/demo/demo.css" />
<script type="text/javascript" src="jquery-easyui-1.10.14/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.10.14/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/product.js"></script>
</head>
<body>
  <h2>상품정보</h2>
  <div style="margin: 20px 0"></div>
  <table id="dg_table" class="easyui-datagrid" title="Basic DataGrid" style="width: 650px; height: 250px" data-options="singleSelect:true,collapsible:true">
    <thead>
      <div style="padding: 5px 0">
        <a href="javascript:void(0)" onclick="javascript:insert_dialog()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">INSERT</a>
        <a href="javascript:void(0)" onclick="javascript:update_dialog()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">UPDATE</a>
        <a href="javascript:void(0)" onclick="javascript:delete_Product()" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">DELETE</a>
        <a href="javascript:void(0)" onclick="javascript:get_product()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">SELECT</a>
      </div>
      <tr>
        <th data-options="field:'id',width:100,align:'center'">아이디</th>
        <th data-options="field:'category',width:150,align:'center'">카테고리</th>
        <th data-options="field:'name',width:150,align:'center'">상품명</th>
        <th data-options="field:'price',width:150,align:'center'">가격</th>
        <th data-options="field:'stock',width:100,align:'center'">재고</th>
      </tr>
    </thead>
  </table>
  <!-- insert dialog start -->
  <div id="insertDialog" class="easyui-dialog" title="Basic Dialog" data-options="closed: true,iconCls:'icon-save'"
    style="width: 600px; height: 400px; padding: 10px">
    <form id="user_form" method="post">
      <div style="margin-bottom: 20px">
        <input class="easyui-textbox" type="text" name="id" style="width: 50%" data-options="label:'ID:',required:true" autofocus />
      </div>
      <div style="margin-bottom: 20px">
        <input class="easyui-textbox" type="text" name="category" style="width: 50%" data-options="label:'카테고리:',required:false" />
      </div>
      <div style="margin-bottom: 20px">
        <input class="easyui-textbox" type="text" name="name" style="width: 50%" data-options="label:'상품명:',required:false" />
      </div>
      <div style="margin-bottom: 20px">
        <input class="easyui-textbox" type="text" name="price" style="width: 50%" data-options="label:'가격:',multiline:true" />
      </div>
      <div style="margin-bottom: 20px">
        <input class="easyui-textbox" type="text" name="stock" style="width: 50%" data-options="label:'재고:'" />
      </div>
      <div style="margin-bottom: 20px"></div>
      <div style="text-align: center; padding: 5px 0">
        <a href="javascript:submit_data()" class="easyui-linkbutton" style="width: 80px">Submit</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:clearForm()" style="width: 80px">Clear</a>
      </div>
    </form>
  </div>
  <!-- insert dialog end -->
  <!-- update dialog start -->
  <div id="updateDialog" class="easyui-dialog" title="Basic Dialog" data-options="closed: true,iconCls:'icon-save'"
    style="width: 600px; height: 400px; padding: 10px">
    <form id="user_form" method="post">
      <div style="margin-bottom: 20px">
        <input class="easyui-textbox" type="text" name="id" style="width: 50%" data-options="label:'ID:',required:true" autofocus />
      </div>
      <div style="margin-bottom: 20px">
        <input class="easyui-textbox" type="text" name="category" style="width: 50%" data-options="label:'카테고리:',required:false" />
      </div>
      <div style="margin-bottom: 20px">
        <input class="easyui-textbox" type="text" name="name" style="width: 50%" data-options="label:'상품명:',required:false" />
      </div>
      <div style="margin-bottom: 20px">
        <input class="easyui-textbox" type="text" name="price" style="width: 50%" data-options="label:'가격:',multiline:true" />
      </div>
      <div style="margin-bottom: 20px">
        <input class="easyui-textbox" type="text" name="stock" style="width: 50%" data-options="label:'재고:'" />
      </div>
      <div style="margin-bottom: 20px"></div>
      <div style="text-align: center; padding: 5px 0">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:submit_data()" style="width: 80px">Submit</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:clearForm()" style="width: 80px">Clear</a>
      </div>
    </form>
  </div>
  <!-- update dialog end -->
</body>
</html>