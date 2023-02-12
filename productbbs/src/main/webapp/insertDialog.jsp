<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품입력</title>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.10.12/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.10.12/themes/icon.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.10.12/demo.css">
<script type="text/javascript" src="jquery-easyui-1.10.12/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.10.12/jquery.easyui.min.js"></script>
</head>
<body>

  <div id="dlg" class="easyui-dialog" title="Basic Dialog" data-options="closed: true,iconCls:'icon-save'" style="width: 600px; height: 400px; padding: 10px">

    <form action="insertProcuct" id="insert" method="post">
      <div style="margin-bottom: 20px">
        <input class="easyui-textbox" type="text" name="id" style="width: 50%" data-options="label:'ID:',required:true" autofocus>
      </div>
      <div style="margin-bottom: 20px">
        <input class="easyui-textbox" type="text" name="category" style="width: 50%" data-options="label:'카테고리:',required:false">
      </div>
      <div style="margin-bottom: 20px">
        <input class="easyui-textbox" type="text" name="name" style="width: 50%" data-options="label:'상품명:',required:false">
      </div>
      <div style="margin-bottom: 20px">
        <input class="easyui-textbox" type="text" name="price" style="width: 50%;" data-options="label:'가격:',multiline:true">
      </div>
      <div style="margin-bottom: 20px">
        <input class="easyui-textbox" type="text" name="stock" style="width: 50%;" data-options="label:'재고:'">
      </div>
      <div style="margin-bottom: 20px">
        <select class="easyui-combobox" name="language" label="Language" style="width: 30%"><option value="ar">Arabic</option>
          <option value="en" selected="selected">English</option>
          <option value="ja">Japanese</option>
          <option value="ko">Korean</option>
        </select>
      </div>
      <div style="text-align: center; padding: 5px 0">
        <a href="#" class="easyui-linkbutton" onclick="submitForm()" style="width: 80px">Submit</a>
        <a href="#" class="easyui-linkbutton" onclick="clearForm()" style="width: 80px">Clear</a>
      </div>
    </form>
  </div>
</body>
</html>