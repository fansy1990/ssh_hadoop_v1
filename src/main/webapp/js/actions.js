$(function() {

	// 绑定button
	$('#btr-hdfs').on('click', function() {
		// ajax 异步提交任务
		var input_ = $('#input-hdfs').val();
		console.info(input_);
		$.ajax({
			url : "test/test_getHdfs.action",
			data: {input:input_},
			context : document.body,
			success : function(data) {
				console.info(data);
				$('#ret-hdfs').html(data);
			}
		});
	});
	// 绑定MR button
	$('#btr-mr').on('click', function() {
		// ajax 异步提交任务
		var input_ = $('#mr-input').val();
		var output_= $('#mr-output').val();
		console.info(input_);
		$('#ret-mr').html('正在运行MR任务，请稍等...');
		$.ajax({
			url : "test/test_runWordCount.action",
			data: {input:input_,output:output_},
			context : document.body,
			success : function(data) {
				console.info(data);
				$('#ret-mr').html(data);
			}
		});
	});
});