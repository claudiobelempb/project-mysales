import { Content } from '@/components/content';
import Sidebar from '@/components/sidebar/Sidebar';
import { Metadata } from 'next';

interface DashboardLayoutProps {
  title: string;
  subTitle: string;
  children?: React.ReactNode;
}

export const metadata: Metadata = {
  title: 'Página Inicial',
  description: 'Estamos construindo um template admin!'
};

export default function DashboardLayout({
  title,
  subTitle,
  children
}: DashboardLayoutProps) {
  return (
    <div className=' flex min-h-screen w-screen'>
      <Sidebar />

      <div className='flex flex-col w-full text-gray-800 dark:text-white bg-gray-300 dark:bg-gray-500 p-7'>
        <Content>{children}</Content>
      </div>
    </div>
  );
}
