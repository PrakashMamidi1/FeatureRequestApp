export class Feature {

    id: number;
    title: string;
    description: string;
    client: string;
    priority: number;
    targetDate: string;
    area:string 


    constructor(title: string, description: string,client: string  ,   priority: number,  targetDate: string, area: string ){
        this.title = title;
        this.description = description;
        this.client = client;
        this.priority = priority;
        this.targetDate = targetDate;
         this.area = area;   
         }

}
