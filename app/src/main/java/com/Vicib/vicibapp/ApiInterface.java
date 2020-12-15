package com.Vicib.vicibapp;

import com.Vicib.vicibapp.District.ResponseDistrict;

import com.Vicib.vicibapp.Gene.ResponsePremiumGenealogy;
import com.Vicib.vicibapp.Gene.ResponseStandardGenealogy;
import com.Vicib.vicibapp.Gene.SponsorTree;
import com.Vicib.vicibapp.MyProfile.ResponseEditProfile;
import com.Vicib.vicibapp.MyProfile.ResponseImageUpload;
import com.Vicib.vicibapp.MyProfile.ResponseImageView;
import com.Vicib.vicibapp.Payout.ResponsePayoutLedger;
import com.Vicib.vicibapp.PremiumPlanReports.ResponsePremiumListLeftSideSales;
import com.Vicib.vicibapp.PremiumPlanReports.ResponsePremiumTeamSalesBVMatching;
import com.Vicib.vicibapp.PremiumPlanReports.ResponsePremiumTeamSalesBonusDetails;
import com.Vicib.vicibapp.Reports.ResponseFirstPurchaseBVReport;
import com.Vicib.vicibapp.Reports.ResponseLeftSideMembers;
import com.Vicib.vicibapp.Reports.ResponseMyProducts;
import com.Vicib.vicibapp.Reports.ResponseSponsorsList;
import com.Vicib.vicibapp.RepurchasePlanReports.ResponseDownlineRepurchaseDetails;
import com.Vicib.vicibapp.RepurchasePlanReports.ResponseRepurchaseBvReport;
import com.Vicib.vicibapp.RepurchasePlanReports.ResponseRepurchaseIncome;
import com.Vicib.vicibapp.RepurchasePlanReports.ResponseRepurchaseIncomeDetails;
import com.Vicib.vicibapp.StandardPlanReports.ResponseStandardLeftSideSales;
import com.Vicib.vicibapp.StandardPlanReports.ResponseStandardTeamSalesBVMatching;
import com.Vicib.vicibapp.StandardPlanReports.ResponseStandardTeamSalesBonusDetails;
import com.Vicib.vicibapp.State.ResponseState;
import com.Vicib.vicibapp.ui.Dashboard.Responsedashboard;


import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("Login")
    Call<ResponseLogin>Login(@Field("username")String username,
                             @Field("password")String password);

    @POST("State_list")
    Call<ResponseState>loadstatelist();

    @FormUrlEncoded
    @POST("District_list")
    Call<ResponseDistrict>loaddistrictlist(@Field("state_name") String sname);





    @FormUrlEncoded
    @POST("Login_check")
    Call<ResponseLoginCheck>LoginCheck(@Field("username") String username);

    @FormUrlEncoded
    @POST("Logout")
    Call<ResponseLogout>Logout(@Field("username") String username);

    @FormUrlEncoded
    @POST("My_products")
    Call<ResponseMyProducts>searchmyproducts(@Field("userid") int userid,
                                             @Field("fromdate") String fromdate,
                                             @Field("todate") String todate);
    @FormUrlEncoded
    @POST("First_purchase_bv_report")
    Call<ResponseFirstPurchaseBVReport>SearchFirstPurchase(@Field("userid") int userid,
                                                        @Field("fromdate") String fromdate,
                                                        @Field("todate") String todate);



    @FormUrlEncoded
    @POST("Sponsors_list")
    Call<ResponseSponsorsList>searchsponsorlist(@Field("userid") int userid);

    @FormUrlEncoded
    @POST("Registration")
    Call<ResponseRegistration>Register(@Field("c_name")String c_name,
                                       @Field("c_firm_name")String c_firm_name,
                                       @Field("d_dob")String d_dob,
                                       @Field("C_MOBILE")String C_MOBILE,
                                       @Field("c_address")String c_address,
                                       @Field("n_pincode")String n_pincode,
                                       @Field("c_country")String c_country,
                                       @Field("C_DISTRICT")String C_DISTRICT,
                                       @Field("C_PANCHAYAT")String C_PANCHAYAT,
                                       @Field("c_nominee_name")String c_nominee_name,
                                       @Field("c_relation")String c_relation,
                                       @Field("c_sponsor_name")String c_sponsor_name,
                                       @Field("c_upline")String c_upline,
                                       @Field("c_position")String c_position,
                                       @Field("c_password")String c_password,
                                       @Field("CONFIRM_PASSWORD")String CONFIRM_PASSWORD,
                                       @Field("c_email_id")String c_email_id,
                                       @Field("c_username")String c_username,
                                       @Field("C_BANK")String C_BANK,
                                       @Field("C_BRANCH")String C_BRANCH,
                                       @Field("C_ACC_NO")String C_ACC_NO,
                                       @Field( "C_PAN")String C_PAN,
                                       @Field("C_IFC_CODE")String C_IFC_CODE);

    @FormUrlEncoded
    @POST("Myteam_left_search_list")
    Call<ResponseLeftSideMembers>SearchLeftSidemembers(@Field("id") int userid,
                                                          @Field("from_date") String fromdate,
                                                          @Field("to_date") String todate,
                                                          @Field("side")String side);

    @FormUrlEncoded
    @POST("Left_side_sales")
    Call<ResponseStandardLeftSideSales>SearchStandardLeftSales(@Field("userid") int userid,
                                                             @Field("from_date") String fromdate,
                                                             @Field("to_date") String todate,
                                                             @Field("side")String side);
    @FormUrlEncoded
    @POST("Team_sales_bv_matching")
    Call<ResponseStandardTeamSalesBVMatching>SearchStandardTeamSalesBV(@Field("userid") int userid,
                                                                     @Field("from_date") String fromdate,
                                                                     @Field("to_date") String todate);

    @FormUrlEncoded
    @POST("Team_sales_bonus_details")
    Call<ResponseStandardTeamSalesBonusDetails>SearchStandardTeamSalesBonus(@Field("userid") int userid,
                                                                         @Field("from_date") String fromdate,
                                                                         @Field("to_date") String todate);

    @FormUrlEncoded
    @POST("Left_side_sale_gold")
    Call<ResponsePremiumListLeftSideSales>SearchPremiumLeftSales(@Field("userid") int userid,
                                                                       @Field("from_date") String fromdate,
                                                                       @Field("to_date") String todate,
                                                                       @Field("side") String side);
    @FormUrlEncoded
    @POST("Team_sales_bv_matching_gold")
    Call<ResponsePremiumTeamSalesBVMatching>SearchPremiumTeamSalesBV(@Field("userid") int userid,
                                                                      @Field("from_date") String fromdate,
                                                                      @Field("to_date") String todate);

    @FormUrlEncoded
    @POST("Team_sales_bonus_details_gold")
    Call<ResponsePremiumTeamSalesBonusDetails>SearchPremiumTeamSalesBonus(@Field("userid") int userid,
                                                                       @Field("from_date") String fromdate,
                                                                       @Field("to_date") String todate);

    @FormUrlEncoded
    @POST("Repurchase_bv_report")
    Call<ResponseRepurchaseBvReport>SearchRepurchaseBVReport(@Field("userid") int userid,
                                                                @Field("from_date") String fromdate,
                                                                @Field("to_date") String todate);

    @FormUrlEncoded
    @POST("Downline_repurchase_details")
    Call<ResponseDownlineRepurchaseDetails>SearchDownlineRepurchase(@Field("userid") int userid,
                                                                    @Field("from_date") String fromdate,
                                                                    @Field("to_date") String todate);

    @FormUrlEncoded
    @POST("Repurchase_income")
    Call<ResponseRepurchaseIncome>SearchRepurchaseIncome(@Field("userid") int userid,
                                                           @Field("from_date") String fromdate,
                                                           @Field("to_date") String todate);

    @FormUrlEncoded
    @POST("Repurchase_income_details")
    Call<ResponseRepurchaseIncomeDetails>SearchRepurchaseIncomeDetails(@Field("userid") int userid,
                                                                @Field("from_date") String fromdate,
                                                                @Field("to_date") String todate);

    @FormUrlEncoded
    @POST("Payout_ledger")
    Call<ResponsePayoutLedger>SearchPayoutLedger(@Field("id") int id,
                                                            @Field("from_date") String fromdate,
                                                            @Field("to_date") String todate);

    @FormUrlEncoded
    @POST("Complaint_list")
    Call<ResponsePayoutLedger>SearchPayoutLedger(@Field("id") int id);


    @FormUrlEncoded
    @POST("Dashboard_view")
    Call<Responsedashboard>SearchDashboard(@Field("userid") int userid);

    @Multipart
    @POST("profile_picture_upload")
    Call<ResponseImageUpload>ImageUpload(@Part("c_profile_photo\";filename=\"myfile.jpg\"") RequestBody file,
                                       @Part("member_id")int member_id);

    @FormUrlEncoded
    @POST("profile_image_view")
    Call<ResponseImageView>ViewPhoto(@Field("user_id") int user_id);






//    @Multipart
//    @POST("User_image_upload")
//    Call<ResponseUserImage>userimageupload(@Part("c_profile_photo\";filename=\"myfile.jpg\"") RequestBody file,
//                                           @Part("member_id") int memberid);



    @FormUrlEncoded
    @POST("Change_password")
    Call<ResponseChangePassword>Changepsd(@Field("userid") String userid,
                                          @Field("current_password") String currentpsd,
                                          @Field("new_password")String newpsd);


    @FormUrlEncoded
    @POST("Gold_api_geneology")
    Call<ResponsePremiumGenealogy>PremiumGene(@Field("userid")int userid);


    @FormUrlEncoded
    @POST("Silver_geneology1")
    Call<ResponseStandardGenealogy>StandardGene(@Field("userid")int userid);


    @FormUrlEncoded
    @POST("profile_update")
    Call<ResponseEditProfile>UpdateProf(@Field("id")int id,
                                        @Field("C_FNAME")String C_FNAME,
                                        @Field("C_GENDER")String C_GENDER,
                                        @Field("c_dob")String c_dob,
                                        @Field("c_mobile")String c_mobile,
                                        @Field("c_email")String c_email,
                                        @Field("c_address")String c_address,
                                        @Field("c_country")String c_country,
                                        @Field("c_state")String c_state,
                                        @Field("C_DISTRICT")String C_DISTRICT,
                                        @Field("C_PANCHAYATH")String C_PANCHAYATH,
                                        @Field("c_zipcode")String c_zipcode,
                                        @Field("n_pancard")String n_pancard,
                                        @Field("C_BANK")String C_BANK,
                                        @Field("C_BRANCH")String C_BRANCH,
                                        @Field("C_ACC_NO")String C_ACC_NO,
                                        @Field("C_IFC_CODE")String C_IFC_CODE,
                                        @Field("c_nominee_name")String c_nominee_name,
                                        @Field("c_relation")String c_relation);





}
