/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * LOV Name             LOV ID
 addressDataQuality	 1
 disabilityType       2
 dobDataQuality       3
 employmentType       4
 ethnicity            5
 fiveValDKRefused     6
 fysbReasonNoServices 7
 gender       	 8
 householdType	 9
 housingStatus	 10
 militaryBranch	 11
 monthsHomelessPastThreeYears	12
 nameDataQuality	 13
 noYes                14
 noYesRefused	 15
 pathHowConfirmed	 16
 pathSMIInformation	 17
 projectType          18
 race         	 19
 reasonNotEnrolled	 20
 referralOutcome	 21
 referralSourceSimple 22
 relationshipToHoH	 23
 residencePrior	 24
 residencePriorLengthOfStay	25
 ssnDataQuality	 26
 state                27
 timesHomelessPastThreeYears	28
 
 * 
 */

function getLOV(lovType, selectedFieldId) {
    getLOVWithSelectedValue(lovType, selectedFieldId, -1);
}

function getLOVWithSelectedValue(lovType, selectedFieldId, selectedOptionIndex) {
    if (selectedFieldId.children('option').length == 1) {
        $.ajax({
            type: "GET",
            url: "../service/lov/" + lovType,
            data: "",
            dataType: "json",
            restful: true,
            contentType: "application/json",
            cache: false,
            timeout: 20000,
            async: true,
            beforeSend: function (xhr) {
                //xhr.setRequestHeader('Authorization',bearer);
            },
            success: function (data) {
                for (var i = 0; i < data.header.count; i++) {
                    var vals = data.body[i].value;
                    if (selectedOptionIndex == vals) {
                        selectedFieldId.append($("<option selected='selected'></option>")
                                .attr("value", vals)
                                .text(data.body[i].name));
                    } else {
                        selectedFieldId.append($("<option></option>")
                                .attr("value", vals)
                                .text(data.body[i].name));
                    }
                }
                selectedFieldId.selectmenu('refresh', true);
            },
            error: function () {
            }
        });
    }
}

function getLOVText(lovType, selectedId, UIfieldId) {
    $.ajax({
        type: "GET",
        url: "../service/lov/" + lovType + "/" + selectedId,
        data: "",
        dataType: "json",
        restful: true,
        contentType: "application/json",
        cache: false,
        timeout: 20000,
        async: true,
        beforeSend: function (xhr) {
            //xhr.setRequestHeader('Authorization',bearer);
        },
        success: function (data) {
            var gotIt = false;
            for (var i = 0; i < data.header.count; i++) {
                if (data.body) {
                    $(UIfieldId).html(data.body[i].name);
                    gotIt = true;
                    break;
                } else {
                    break;
                }
            }
            if (!gotIt) {
                $(UIfieldId).html("Details not provided for " + lovType);
            }
        },
        error: function () {

        }
    });
}




