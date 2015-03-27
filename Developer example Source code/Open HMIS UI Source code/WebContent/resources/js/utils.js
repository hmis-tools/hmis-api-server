/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    function configDate(dateClass){

            var optAvgAge = 90;
            dateClass.datepicker().on("show",function(){
                $(this).val("01/01/1930").datepicker('update');
            });

            var changeYear = dateClass.datepicker("option", "changeYear");
            dateClass.datepicker("option", "changeYear", true);

            var dateFormat = dateClass.datepicker("option", "dateFormat");
            dateClass.datepicker("option", "dateFormat", "mm/dd/yy");		
                    var dt = new Date();
                    var range= dt.getFullYear()-optAvgAge+":"+dt.getFullYear();
            var yearRange = dateClass.datepicker("option", "yearRange");
            dateClass.datepicker("option", "yearRange", range);		

     }

 
    function OformatDate(millisec){
          var dobDt = new Date();
          dobDt.setTime(millisec);
          var day = ("0" + dobDt.getDate()).slice(-2);
          var month = ("0" + (dobDt.getMonth() + 1)).slice(-2);
          var fmtDate = dobDt.getFullYear()+"-"+(month)+"-"+(day) ;
          return fmtDate;
    }
    
    function OformatStrDate(strDate){
          var dobDt = new Date(strDate);
          var day = ("0" + dobDt.getDate()).slice(-2);
          var month = ("0" + (dobDt.getMonth() + 1)).slice(-2);
          var fmtDate = dobDt.getFullYear()+"-"+(month)+"-"+(day) ;
          return fmtDate;
    }
    
    function checkForEmpty(str){
        if(str){
            return str;
        }else{
            return -1;
        }
    }
    

