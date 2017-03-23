var UITree = function () {
    return {
        //main function to initiate the module
        init: function () {
            var DataSourceTree = function (options) {
                this._data = options.data;
                this._delay = options.delay;
            };

            DataSourceTree.prototype = {
                data: function (options, callback) {
                    var self = this;
                    setTimeout(function () {
                        var data = $.extend(true, [], self._data);
                        callback({ data: data });
                    }, this._delay)
                }
            };
			
			 $.ajax({
                        url: 'insuranceCompany/getInsuranceCompanyList.do',
                        type: 'POST',
                        dataType: 'json',
                        success: function (response) {
                        	
                            if (response.success===true){
                            	console.log(response.aaData);
								     // INITIALIZING TREE
								 var treeDataSource = new DataSourceTree({
									data: response.aaData
									,
									delay: 400
								});

								$('#MyTree').tree({
									dataSource: treeDataSource,
									multiSelect: true,
									loadingHTML: '<div class="tree-loading"><i class="fa fa-rotate-right fa-spin"></i></div>'
								});
							}
                        },
                        error: function (response) {
                            
                        }
            });
           
        }
    };
}();