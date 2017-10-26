package com.example.android.realestatepractice;

/**
 * Created by Angela on 9/26/17.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "realEstateQuiz";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "questionId";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA = "opta"; //option a
    private static final String KEY_OPTB = "optb"; //option b
    private static final String KEY_OPTC = "optc"; //option c
    private static final String KEY_OPTD = "optd"; //option d

    private SQLiteDatabase dbase;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT," + KEY_OPTD + " TEXT)";
        db.execSQL(sql);
        addQuestions(db);
        //db.close();
    }

    private void addQuestions(SQLiteDatabase db) {
        Question q1 = new Question("When a real estate professional exaggerates " +
                "about a parcel of property, they are likely:",
                "Misrepresenting the property",
                "Guilty of fraud",
                "Puffing",
                "All of the above",
                "Puffing");
        this.addQuestion(q1, db);
        Question q2 = new Question("If a seller hires multiple brokers to find a buyer " +
                "for his or her property, but the seller agrees to pay only one commission to " +
                "whichever broker finds the ready, willing, and able buyer who the seller accepts, " +
                "then the seller has given a/an:",
                "Open listing",
                "Exclusive Right to Sell listing",
                "Exclusive Agency listing",
                "Closed listing",
                "Open listing");
        this.addQuestion(q2, db);
        Question q3 = new Question("Which real estate activity does not require a real " +
                "estate license?",
                "Selling property on behalf of a third party",
                "Leasing property on behalf of a third party",
                "Appraising property",
                "None of the above",
                "Appraising property");
        this.addQuestion(q3, db);
        Question q4 = new Question("If a broker charges 6% commission on the first " +
                "$50,000 of a sale and 4% on the next 50,000 of a sale and 2% on the balance, how " +
                "much commission would the broker receive if the sale price was $150,000?",
                "$4,000",
                "$5,000",
                "$6,000",
                "$7,000",
                "$6,000");
        this.addQuestion(q4, db);
        Question q5 = new Question("A form of an attachment is:",
                "Extension",
                "A lien",
                "Earnest money",
                "A lockbox",
                "A lien");
        this.addQuestion(q5, db);
        Question q6 = new Question("A VA loan is guaranteed:",
                "0%",
                "50%",
                "75%",
                "100%",
                "100%");
        this.addQuestion(q6, db);
        Question q7 = new Question("Option money buys:",
                "A percentage of the sale",
                "The time only",
                "Title fees",
                "Closing costs",
                "The time only");
        this.addQuestion(q7, db);
        Question q8 = new Question("A buyer who is prepared to buy a home on the seller’s " +
                "terms and move forward with a contract is:",
                "A buyer's agent",
                "A ready, willing, and able buyer",
                "An invested buyer",
                "An automated buyer",
                "A ready, willing, and able buyer");
        this.addQuestion(q8, db);
        Question q9 = new Question("Under which type of agency can an owner retain his " +
                "or her right to sell the property themselves and not pay commission?",
                "Exclusive Agency",
                "Open Listing",
                "Exclusive Right-to-Sell Listing",
                "Both A and B",
                "Both A and B");
        this.addQuestion(q9, db);
        Question q10 = new Question("How many feet are in a yard",
                "1",
                "3",
                "6",
                "12",
                "3");
        this.addQuestion(q10, db);
        Question q11 = new Question("How many feet are in an acre",
                "34,560",
                "36,450",
                "43,560",
                "45,630",
                "43,560");
        this.addQuestion(q11, db);
        Question q12 = new Question("In what type of purchase does the owner receive the " +
                "deed to an individual unit and to a percent of ownership in common elements?",
                "Co-op",
                "House",
                "Duplex",
                "Condo",
                "Condo");
        this.addQuestion(q12, db);
        Question q13 = new Question("Which type of purchase does a buyer purchase a unit " +
                "in a building owned by a corporation where purchasers must buy stock in the owning " +
                "company, entitling them to a proprietary lease for as long as they want?",
                "Co-op",
                "House",
                "Duplex",
                "Condo",
                "Co-op");
        this.addQuestion(q13, db);
        Question q14 = new Question("What is an encumbrance?",
                "A delay on closing",
                "A lien or claim against property rights",
                "The inability to get a loan",
                "The square footage of a property",
                "A lien or claim against property rights");
        this.addQuestion(q14, db);
        Question q15 = new Question("Valuable consideration is:",
                "Something owed to your clients",
                "Having monetary value",
                "The sentimental value of a home",
                "How you select the listing price of the property",
                "Having monetary value");
        this.addQuestion(q15, db);
        Question q16 = new Question("In an Exclusive Right-to-Sell, the broker:",
                "Never gets commission if the property is sold",
                "Always gets commission if the property is sold",
                "Only gets commission if they sell the property themselves",
                "Always splits the commission with another agent regardless of who sells the " +
                        "property",
                "Always gets commission if the property is sold");
        this.addQuestion(q16, db);
        Question q17 = new Question("Dedication is:",
                "A variance",
                "A type of leasehold estate",
                "A voluntary alienation",
                "Accrued interest",
                "A voluntary alienation");
        this.addQuestion(q17, db);
        Question q18 = new Question("A business has been operating for 10 years with no " +
                "zoning laws. This year, the property was annexed into the county where zoning " +
                "requires residential use only. If the business continues to operate, it is a/an:",
                "Nonconforming use",
                "Variance",
                "Involuntary alienation",
                "Illegal use of the business",
                "Nonconforming use");
        this.addQuestion(q18, db);
        Question q19 = new Question("A homeowner wants to build a back porch on her house, " +
                "but it is not allowed in her zone. In order to build it, she must appeal for:",
                "A permit",
                "A variance",
                "Destructive cause",
                "Construction cause",
                "A variance");
        this.addQuestion(q19, db);
        Question q20 = new Question("Three family members own a house together. " +
                "All of their names are on the title and they have right to survivorship. They are:",
                "Joint tenants",
                "Tenants in common",
                "Tenancy in severalty",
                "Shared tenants",
                "Joint tenants");
        this.addQuestion(q20, db);
        Question q21 = new Question("The money a buyer gives to the agent with an offer" +
                " to purchase that shows an intent to fulfill the terms of the contract with the " +
                "seller is known as:",
                "A deposit",
                "A down payment",
                "Earnest money",
                "Consideration",
                "Earnest money");
        this.addQuestion(q21, db);
        Question q22 = new Question("This type of deed is used when the grantor " +
                "may or may not have any interest in the property:",
                "A quick claim deed",
                "A special warranty deed",
                "A general warranty deed",
                "None of the above",
                "A quick claim deed");
        this.addQuestion(q22, db);
        Question q23 = new Question("The right to take private property through a " +
                "condemnation action for the benefit of the public is called:",
                "Assignment",
                "Property action",
                "Hostile takeover",
                "Eminent domain",
                "Eminent domain");
        this.addQuestion(q23, db);
        Question q24 = new Question("A type of legal description using direction and" +
                " distance from a specific point of beginning is:",
                "A survey",
                "A plat description",
                "Metes and bounds description",
                "Square footage",
                "Metes and bounds description");
        this.addQuestion(q24, db);
        Question q25 = new Question("Michele owns 5 acres and a building that she is " +
                "letting an animal shelter use. If the animal shelter tried to change the property " +
                "for a different use or sell it, then it would go to Michele’s heirs. " +
                "This is an example of:",
                "Fee simple",
                "Fee simple determinable estate",
                "A leasehold estate",
                "A life estate",
                "Fee simple determinable estate");
        this.addQuestion(q25, db);
        Question q26 = new Question("Frank owns his house and the land it sits on. The land" +
                " is considered:",
                "A leasehold",
                "Leased",
                "Fee simple",
                "Rented",
                "Fee simple");
        this.addQuestion(q26, db);
        Question q27 = new Question("Joe developed a building in a tourist area. " +
                "He owns the building, but not the land it sits on. The land is considered:",
                "Leased land",
                "Fee simple land",
                "A life estate",
                "Conforming land",
                "Leased land");
        this.addQuestion(q27, db);
        Question q28 = new Question("What nearby, comparable properties have sold for " +
                "is the best indication of the value of the subject property. This is considered:",
                "Market analysis",
                "Market data approach",
                "Comparable approach",
                "Sold analysis",
                "Market data approach");
        this.addQuestion(q28, db);
        Question q29 = new Question("A package mortgage loan:",
                "Has only real property as collateral",
                "Has only personal property as collateral",
                "Has real and personal property as collateral",
                "Has no collateral",
                "Has real and personal property as collateral");
        this.addQuestion(q29, db);
        Question q30 = new Question("Does an Estate for Years automatically renew?",
                "Yes",
                "No",
                "It depends on the contract",
                "It is never specified",
                "No");
        this.addQuestion(q30, db);
        Question q31 = new Question("A blanket mortgage loan:",
                "Has real and personal property as collateral",
                "Has one parcel of real property as collateral",
                "Has two or more parcels of real property as collateral",
                "Has no collateral",
                "Has two or more parcels of real property as collateral");
        this.addQuestion(q31, db);
        Question q32 = new Question("A rapid, sudden tearing away of real property by" +
                " natural forces is:",
                "Avulsion",
                "Puffing",
                "Disaster",
                "Erosion",
                "Erosion");
        this.addQuestion(q32, db);
        Question q33 = new Question("What are the rules and regulations of the subdivision?",
                "Whatever the association president says",
                "What's recorded in the landlord's office",
                "The declaration contract",
                "Restrictive covenants",
                "Restrictive covenants");
        this.addQuestion(q33, db);
        Question q34 = new Question("Hank needs an easement on Jan’s property for " +
                "his driveway. Jan agrees to grant this easement only during Hank’s lifetime " +
                "while he lives at the property. What is this called?",
                "Personal easement in gross",
                "Property easement in gross",
                "Lifetime easement",
                "This type of easement doesn't exist",
                "Personal easement in gross");
        this.addQuestion(q34, db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
// Create tables again
        onCreate(db);
    }

    // Adding new question
    public void addQuestion(Question quest, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQuestion());
        values.put(KEY_ANSWER, quest.getAnswer());
        values.put(KEY_OPTA, quest.getOpta());
        values.put(KEY_OPTB, quest.getOptb());
        values.put(KEY_OPTC, quest.getOptc());
        values.put(KEY_OPTD, quest.getOptd());

        // Inserting Row
           db.insert(TABLE_QUEST, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
            String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
            dbase = this.getReadableDatabase();
            Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    Question quest = new Question();
                    quest.setQuestionId(cursor.getInt(0));
                    quest.setQuestion(cursor.getString(1));
                    quest.setAnswer(cursor.getString(2));
                    quest.setOpta(cursor.getString(3));
                    quest.setOptb(cursor.getString(4));
                    quest.setOptc(cursor.getString(5));
                    quest.setOptd(cursor.getString(6));
                    quesList.add(quest);
                } while (cursor.moveToNext());
            }
        // return quest list
                cursor.close();
                dbase.close();
                return quesList;
            }

    public int rowcount() {
        int row = 0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row = cursor.getCount();

        cursor.close();
        return row;
    }
}